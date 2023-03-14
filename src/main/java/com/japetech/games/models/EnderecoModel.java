package com.japetech.games.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_JPT_ENDERECO")
public class EnderecoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(nullable = false, length = 100, name = "NM_LOGRADOURO")
    private String logradouro;

    @Column(nullable = false, length = 10, name = "NR_NUMERO")
    private String numero;

    @Column(nullable = false, length = 50, name = "NM_BAIRRO")
    private String bairro;

    @Column(nullable = false, length = 50, name = "NM_CIDADE")
    private String cidade;

    @Column(nullable = false, length = 2, name = "NM_ESTADO")
    private String estado;

    @Column(nullable = false, name = "NR_CEP")
    private String cep;


}
