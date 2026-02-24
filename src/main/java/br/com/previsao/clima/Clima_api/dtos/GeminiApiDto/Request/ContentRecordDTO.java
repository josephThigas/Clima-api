package br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContentRecordDTO{
    private String role ;
    private List<PathRecordDTO> parts ;

    public ContentRecordDTO(List<PathRecordDTO> pathRecordDTOS) {
        this.role = "user";
        this.parts = pathRecordDTOS;
    }
}

