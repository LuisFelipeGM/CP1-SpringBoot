package com.japetech.games.gamesDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnderecoDto  {

    private Long id;

    @NotBlank(message = "O logradouro é obrigatório")
    @Size (max = 100, message = "O logradouro deve ter no máximo 100 caracteres")
    private String logradouro;

    private Integer numero;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(max = 50, message = "O bairro ter no máximo 50 caracteres")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatório")
    @Size(max = 50, message = "O cidade ter no máximo 50 caracteres")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 2, message = "O estado ter no máximo 2 caracteres")
    private String estado;

    @NotBlank(message = "O cep é obrigatório")
    private String cep;
}
