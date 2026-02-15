package br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos;
import java.util.List;



public record GetOpenWeatherDto(
            CoordDTO coord,
            List<WeatherDTO> weather,
            String base,
            MainDTO main,
            Integer visibility,
            WindDTO wind,
            CloudsDTO clouds,
            Long dt,
            SysDTO sys,
            Integer timezone,
            Long id,
            String name,
            Integer cod
    ) {}

