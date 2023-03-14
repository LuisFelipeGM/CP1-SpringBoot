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
    @Column(name = "ID_EMPRESA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50, name = "NM_EMPRESA")
    private String nome;

    @Column(nullable = false, length = 14, unique = true, name = "CNPJ_EMPRESA")
    @CNPJ
    private Integer cnpj;

    @Column(nullable = false, length = 50, name = "NM_FANTASIA")
    private String nomeFantasia;

    @Column(nullable = false, length = 2, name = "NR_DDD")
    @Pattern(regexp = "^[1-9]{2}$")
    private Integer ddd;

    @Column(nullable = false, length = 9, name = "NR_TELEFONE")
    @Pattern(regexp = "^(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private Integer numTelefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "id")
    private EnderecoModel endereco;

}
