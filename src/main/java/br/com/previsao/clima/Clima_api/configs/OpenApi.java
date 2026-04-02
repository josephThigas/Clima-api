package br.com.previsao.clima.Clima_api.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {
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
