package com.japetech.games.gamesDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class EmpresaDto {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    private String nome;

    private Long cnpj;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(max = 50, message = "O nome fantasia deve ter no máximo 50 caracteres")
    private String nomeFantasia;

    private Integer ddd;

    private Integer telefone;

    private EnderecoDto endereco;

}
