package br.com.previsao.clima.Clima_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String user_hash;


    @OneToMany(mappedBy = "user")
    private List<ChatHistoryEntity> chatHistory = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserIpHistoryEntity> userIpHistory = new ArrayList<>();

}
