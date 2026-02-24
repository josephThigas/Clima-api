package br.com.previsao.clima.Clima_api.controllers;

import br.com.previsao.clima.Clima_api.dtos.GeminiApiDto.Response.GeminiResponseDTO;
import br.com.previsao.clima.Clima_api.dtos.RequisicaoGeminiFrontDTO;
import br.com.previsao.clima.Clima_api.services.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/ia"))
public class GeminiController {
    private final GeminiService service;

    public GeminiController(GeminiService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<GeminiResponseDTO> ChatRequest(@RequestBody RequisicaoGeminiFrontDTO msg) {
        return ResponseEntity.ok().body(this.service.generateMensagemFromGemini(msg.text()));
    }
}
