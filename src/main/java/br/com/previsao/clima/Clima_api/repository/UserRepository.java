package br.com.previsao.clima.Clima_api.repository;

import br.com.previsao.clima.Clima_api.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}