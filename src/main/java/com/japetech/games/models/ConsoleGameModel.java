package com.japetech.games.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_JPT_CONSOLE_GAME")
public class ConsoleGameModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataLancamento;

    @Column(nullable = false, length = 9)
    private Float valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_console")
    private ConsoleModel console;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_game")
    private GameModel game;

}
