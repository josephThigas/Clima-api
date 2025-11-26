package br.com.previsao.clima.Clima_api;

public record PrevisaoItemDTO(
        String dataHora,
        double temperatura,
        String descricao,
        String pais
) {
}