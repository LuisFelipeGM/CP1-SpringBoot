package com.japetech.games.gamesDtos;

import com.japetech.games.models.ConsoleModel;
import com.japetech.games.models.GameModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsoleGameDto {

    private LocalDate dataLancamento;

    private Float valor;

    private ConsoleDto console;

    private GameDto game;

}
