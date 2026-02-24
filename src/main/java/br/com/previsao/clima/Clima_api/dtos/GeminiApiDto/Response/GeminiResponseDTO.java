package br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeminiResponseDTO(
        List<Candidate> candidates,
        UsageMetadata usageMetadata,
        String modelVersion,
        String responseId
) {
    public record Candidate(
            Content content,
            String finishReason,
            int index
    ) {}

    public record Content(
            List<Part> parts,
            String role
    ) {}

    public record Part(
            String text
    ) {}

    public record UsageMetadata(
            int promptTokenCount,
            int candidatesTokenCount,
            int totalTokenCount,
            int thoughtsTokenCount,
            List<TokenDetail> promptTokensDetails
    ) {}

    public record TokenDetail(
            String modality,
            int tokenCount
    ) {}
}