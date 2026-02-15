package br.com.previsao.clima.Clima_api.controllers;

import br.com.previsao.clima.Clima_api.clients.ClimaApiClient;
import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherDto;
import br.com.previsao.clima.Clima_api.services.ClimaService;
import br.com.previsao.clima.Clima_api.dtos.PrevisaoItemDTO;
import br.com.previsao.clima.Clima_api.dtos.ClimaAtualDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Clima", description = "Endpoints para consulta de clima e previsão")
public class ClimaController {


    @Autowired
    private ClimaService climaService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados do clima retornados com sucesso (DTO)"),
            @ApiResponse(responseCode = "404", description = "Cidade não encontrada na API OpenWeather")
    })
    @GetMapping("/clima/{cidade}")
    @Operation(summary = "Busca o clima atual de uma cidade",
            description = "Retorna um JSON limpo (DTO) com os dados principais do clima.")
    public ResponseEntity<Object> getClima(@PathVariable String cidade) {
        return ResponseEntity.ok().body(climaService.buscarClimaPorCidade(cidade));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de previsões retornada com sucesso (Lista de DTOs)"),
            @ApiResponse(responseCode = "404", description = "Cidade não encontrada na API OpenWeather")
    })
    @GetMapping("/previsao/{cidade}")
    @Operation(summary = "Busca a previsão do tempo para 5 dias",
            description = "Retorna uma LISTA de DTOs limpos com a previsão (5 dias / 3 horas)")
    public ResponseEntity<Object> getPrevisao(@PathVariable String cidade) {

        List<PrevisaoItemDTO> listaDto = climaService.buscarPrevisao(cidade);

        if (listaDto != null && !listaDto.isEmpty()) {
            return ResponseEntity.ok(listaDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}