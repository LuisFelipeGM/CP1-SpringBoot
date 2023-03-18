package com.japetech.games.gamesDtos;

import com.japetech.games.models.ConsoleModel;
import com.japetech.games.models.GameModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsoleGameDto {

    @NotBlank(message = "A Data de Lançamento é obrigatório")
    private LocalDate dataLancamento;

    @NotBlank(message = "O valor do jogo é obrigatório")
    @Size(max = 9, message = "O valor do jogo deve ter no máximo 9 caracteres")
    private Float valor;

}
