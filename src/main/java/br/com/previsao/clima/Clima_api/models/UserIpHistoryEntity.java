'package br.com.previsao.clima.Clima_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserIpHistoryEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user;

    @Column
    private String user_ip;

    @Column
    private String endereco;

}
