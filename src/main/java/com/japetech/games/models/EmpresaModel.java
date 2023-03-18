package com.japetech.games.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
@Data
@Entity
@Table(name = "TB_JPT_EMPRESA")
public class EmpresaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private Long cnpj;

    @Column(nullable = false, length = 50)
    private String nomeFantasia;

    @Column(nullable = false, length = 2)
    private Integer ddd;

    @Column(nullable = false, length = 9)
    private Integer telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;

}
