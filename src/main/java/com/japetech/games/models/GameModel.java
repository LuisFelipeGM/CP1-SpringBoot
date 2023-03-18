package com.japetech.games.models;

import com.japetech.games.annotations.StringGames;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_JPT_GAME")
public class GameModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @StringGames
    @Column(nullable = false, length = 50)
    private String nome;

    @StringGames
    @Column(nullable = false, length = 50)
    private String nomeDev;


}
