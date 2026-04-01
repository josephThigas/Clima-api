package br.com.previsao.clima.Clima_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user;

    @Column
    private String message;


}
