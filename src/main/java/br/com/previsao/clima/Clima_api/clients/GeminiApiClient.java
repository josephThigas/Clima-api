package br.com.previsao.clima.Clima_api.clients;

import br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Response.GeminiResponseDTO;
import br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Request.ChatRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "GeminiApi",url = "https://generativelanguage.googleapis.com/v1beta/models")
public interface GeminiApiClient {

    @PostMapping("gemini-2.5-flash:generateContent")
    public GeminiResponseDTO ChatRequest(@RequestBody ChatRequestDTO chatRequestDTO,
                                         @RequestHeader("x-goog-api-key") String apiKey
    );

    @PostMapping("gemini-2.5-flash:streamGenerateContent?alt=sse")
    public feign.Response ChatRequestStream(ChatRequestDTO chatRequestDTO);

}
