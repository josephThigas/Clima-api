package br.com.previsao.clima.Clima_api.services;

import br.com.previsao.clima.Clima_api.clients.ClimaApiClient;
import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherDto;
import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherForecastDto;
import br.com.previsao.clima.Clima_api.dtos.PrevisaoItemDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimaService {

    private final ClimaApiClient climaApiClient;

    @Value("${api.key.id}")
    private String apiKey;

    public ClimaService(ClimaApiClient climaApiClient) {
        this.climaApiClient = climaApiClient;
    }

    public GetOpenWeatherDto buscarClimaPorCidade(String cidade) {
        try {
            return this.climaApiClient.puxarClimaAtualPeloNomeDacidade(cidade,apiKey);
        }catch (RuntimeException ex){
            //Adicionar um handler de erro
            return null;
        }
    }

    public List<PrevisaoItemDTO> buscarPrevisao(String cidade) {
        try {
            GetOpenWeatherForecastDto resposta = climaApiClient.puxarPrevisaoPeloNomeDaCidade(
                    cidade,
                    apiKey,
                    "metric",
                    "pt_br"
            );

            if (resposta == null || resposta.list() == null || resposta.list().isEmpty()) {
                return null;
            }

            List<PrevisaoItemDTO> previsoes = new ArrayList<>();
            String pais = resposta.city() != null ? resposta.city().country() : null;

            for (GetOpenWeatherForecastDto.ForecastItemDTO item : resposta.list()) {
                if (item == null) {
                    continue;
                }

                String dataHora = item.dataHora();
                double temperatura = item.main() != null && item.main().temp() != null ? item.main().temp() : 0.0;
                String descricao = item.weather() != null
                        && !item.weather().isEmpty()
                        && item.weather().get(0) != null
                        ? item.weather().get(0).description()
                        : null;

                previsoes.add(new PrevisaoItemDTO(dataHora, temperatura, descricao, pais));
            }

            return previsoes.isEmpty() ? null : previsoes;

        } catch (Exception e) {
            System.err.println("Erro ao buscar previsão: " + e.getMessage());
            return null;
        }
    }



}