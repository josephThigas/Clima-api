package br.com.previsao.clima.Clima_api.services;

import br.com.previsao.clima.Clima_api.clients.ClimaApiClient;
import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherDto;
import br.com.previsao.clima.Clima_api.dtos.PrevisaoItemDTO;
import br.com.previsao.clima.Clima_api.dtos.ClimaAtualDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimaService {

    private final ClimaApiClient climaApiClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key.id}")
    private String apiKey;

    public ClimaService(ClimaApiClient climaApiClient) {
        this.climaApiClient = climaApiClient;
    }

    public GetOpenWeatherDto buscarClimaPorCidade(String cidade) {
        try {
            return this.climaApiClient.puxarClimaPeloNomeDacidade(cidade,apiKey);
        }catch (RuntimeException ex){
            //Adicionar um handler de erro
            return null;
        }
    }

    public List<PrevisaoItemDTO> buscarPrevisao(String cidade) {
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric&lang=pt_br",
                cidade,
                apiKey
        );

        try {
            JsonNode respostaJson = restTemplate.getForObject(url, JsonNode.class);

            if (respostaJson == null) {
                return null;
            }

            List<PrevisaoItemDTO> previsoes = new ArrayList<>();
            JsonNode listaNode = respostaJson.path("list");

            String pais = respostaJson.path("city").path("country").asText();

            if (listaNode.isArray() && !listaNode.isEmpty()) {

                for (JsonNode item : listaNode) {

                    String dataHora = item.path("dt_txt").asText();
                    double temperatura = item.path("main").path("temp").asDouble();
                    String descricao = item.path("weather").path(0).path("description").asText();

                    previsoes.add(new PrevisaoItemDTO(dataHora, temperatura, descricao, pais));
                }
            }
            return previsoes;

        } catch (Exception e) {
            System.err.println("Erro ao buscar previsão: " + e.getMessage());
            return null;
        }
    }



}