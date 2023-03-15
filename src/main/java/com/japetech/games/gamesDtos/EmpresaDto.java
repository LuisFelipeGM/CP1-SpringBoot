package com.japetech.games.gamesDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class EmpresaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    private String nome;

    @NotBlank(message = "O cnpj é obrigatório")
    @Size(max = 14, message = "O cnpj deve ter no máximo 14 caracteres")
    private Integer cnpj;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(max = 50, message = "O nome fantasia deve ter no máximo 50 caracteres")
    private String nomeFantasia;

    @NotBlank(message = "O DDD é obrigatório")
    @Size(max = 2, message = "O DDD deve ter no máximo 2 caracteres")
    private Integer ddd;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 9, message = "O telefone de deve ter no máximo 9 caracteres")
    private Integer numTelefone;


}
