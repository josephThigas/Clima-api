package br.com.previsao.clima.Clima_api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ClimaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimaApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Previsão do Tempo 4ºP")
                        .version("1.0.0")
                        .description("API RESTful criada para o projeto de S.I., consumindo a OpenWeather API.")
                        .contact(new Contact()
                                .name("Thiago José")
                                .email("thiagopombos@hotmail.com")
                        )
                );
    }
}