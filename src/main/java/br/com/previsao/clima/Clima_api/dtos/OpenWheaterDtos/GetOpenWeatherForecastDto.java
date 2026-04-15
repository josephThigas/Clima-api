package br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GetOpenWeatherForecastDto(
        List<ForecastItemDTO> list,
        ForecastCityDTO city,
        String cod
) {

    public record ForecastItemDTO(
            @JsonProperty("dt_txt") String dataHora,
            ForecastMainDTO main,
            List<ForecastWeatherDTO> weather,
            Double pop
    ) {
    }

    public record ForecastMainDTO(
            Double temp
    ) {
    }

    public record ForecastWeatherDTO(
            String description
    ) {
    }

    public record ForecastCityDTO(
            String country
    ) {
    }
}
