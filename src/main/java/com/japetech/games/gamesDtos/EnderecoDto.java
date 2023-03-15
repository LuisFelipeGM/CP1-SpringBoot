package com.japetech.games.gamesDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class EnderecoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O logradouro é obrigatório")
    @Size (max = 100, message = "O logradouro deve ter no máximo 100 caracteres")
    private String logradouro;

    @NotBlank(message = "O número é obrigatório")
    @Size(max = 10, message = "O número ter no máximo 10 caracteres")
    private String numero;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(max = 50, message = "O bairro ter no máximo 50 caracteres")
    private String bairro;

    @NotBlank(message = "O cidade é obrigatório")
    @Size(max = 50, message = "O cidade ter no máximo 50 caracteres")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 2, message = "O estado ter no máximo 2 caracteres")
    private String estado;

    @NotBlank(message = "O cep é obrigatório")
    private String cep;
}
