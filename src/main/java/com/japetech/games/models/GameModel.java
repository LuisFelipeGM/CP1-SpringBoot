package com.japetech.games.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_JPT_ENDERECO")
public class GameModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GAME")
    private Long id;

    @Column(nullable = false, length = 50, name = "NM_GAME")
    private String nome;

    @Column(nullable = false, length = 50, name = "NM_DEV")
    private String nomeDev;


}
