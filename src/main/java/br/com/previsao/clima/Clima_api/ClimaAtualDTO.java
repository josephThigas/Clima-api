package br.com.previsao.clima.Clima_api;

public record ClimaAtualDTO(
        String cidade,
        double temperatura,
        double sensacaoTermica,
        String descricao,
        String pais
) {
}