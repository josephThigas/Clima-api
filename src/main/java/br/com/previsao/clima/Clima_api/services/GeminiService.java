package br.com.previsao.clima.Clima_api.services;

import br.com.previsao.clima.Clima_api.clients.GeminiApiClient;
import br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Request.ChatRequestDTO;
import br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Response.GeminiResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeminiService {
    private final GeminiApiClient apiClient;
    private final String apiKey;

    public GeminiService(GeminiApiClient apiClient,@Value("${api.key.gemini}") String apiKey) {
        this.apiClient = apiClient;
        this.apiKey = apiKey;
    }

    public GeminiResponseDTO generateMensagemFromGemini(String text){
        ChatRequestDTO chatRequestDTO = new ChatRequestDTO();
        chatRequestDTO.appendNewContentToContext(text);
        return this.apiClient.ChatRequest(chatRequestDTO,this.apiKey);
    }



}
