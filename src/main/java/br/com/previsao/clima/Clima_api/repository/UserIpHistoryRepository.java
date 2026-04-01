package br.com.previsao.clima.Clima_api.repository;

import br.com.previsao.clima.Clima_api.models.UserIpHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIpHistoryRepository extends JpaRepository<UserIpHistoryEntity, Long> {
}