package br.com.previsao.clima.Clima_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClimaAtualDTO(
        String cidade,
        double temperatura,
        double sensacaoTermica,
        String descricao,
        String pais
) {
}