package com.japetech.games.gamesDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConsoleDto {

    @NotBlank(message = "O nome do console é obrigatório")
    @Size(max = 50, message = "O nome do console deve ter no máximo 50 caracteres")
    private String nome;

}
