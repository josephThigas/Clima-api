package br.com.previsao.clima.Clima_api.dtos;

public record PrevisaoItemDTO(
        String dataHora,
        double temperatura,
        String descricao,
        String pais
) {
}