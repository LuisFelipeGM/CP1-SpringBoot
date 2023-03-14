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
    @Column(name = "ID_CONSOLE_GAME")
    private Long id;

    @Column(nullable = false, name = "DT_LANCAMENTO")
    private LocalDate dataLancamento;

    @Column(nullable = false, length = 9, name = "NR_VALOR")
    private Float valor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONSOLE", referencedColumnName = "id")
    private ConsoleModel console;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GAME", referencedColumnName = "id")
    private GameModel game;

}
