package br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatRequestDTO {

    private List<ContentRecordDTO> contents = new ArrayList<>();

    public void appendNewContentToChat(String role, String text){
        this.contents.add(new ContentRecordDTO(role,List.of(new PathRecordDTO(text))));
    }
    public void appendNewContentToContext(String text){
        this.contents.add(new ContentRecordDTO(List.of(new PathRecordDTO(text))));
    }
}
