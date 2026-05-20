package br.com.previsao.clima.Clima_api.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                    "https://clima-app-neon-one.vercel.app", // Front-end em produção (Vercel)
                    "http://localhost:5173",                 // Teste local do Vite
                    "http://localhost:3000"                  // Teste local padrão
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
