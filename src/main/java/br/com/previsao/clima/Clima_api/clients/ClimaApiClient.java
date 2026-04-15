package br.com.previsao.clima.Clima_api.clients;


import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherDto;
import br.com.previsao.clima.Clima_api.dtos.OpenWheaterDtos.GetOpenWeatherForecastDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ClimaTempoAPI",url = "https://api.openweathermap.org/")
public interface ClimaApiClient {

    @GetMapping("data/2.5/weather")
    public GetOpenWeatherDto puxarClimaAtualPeloNomeDacidade(@RequestParam(name = "q")String nomeDaCidade,
                                                             @RequestParam(name = "appid") String chaveApi);

    @GetMapping("data/2.5/weather")
    public GetOpenWeatherDto puxarClimaPorLatitudeLongitude(@RequestParam(name = "lon")Long longitude,
                                                            @RequestParam(name = "lat")Long latitude,
                                                            @RequestParam(name = "appid") String chaveApi);

    @GetMapping("data/2.5/forecast")
    public GetOpenWeatherForecastDto puxarPrevisaoPeloNomeDaCidade(@RequestParam(name = "q") String nomeDaCidade,
                                                                    @RequestParam(name = "appid") String chaveApi,
                                                                    @RequestParam(name = "units") String unidade,
                                                                    @RequestParam(name = "lang") String idioma);


}
