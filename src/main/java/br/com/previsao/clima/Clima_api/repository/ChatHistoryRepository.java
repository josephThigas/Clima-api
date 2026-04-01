package br.com.previsao.clima.Clima_api.repository;

import br.com.previsao.clima.Clima_api.models.ChatHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatHistoryRepository extends JpaRepository<ChatHistoryEntity , Long> {
}