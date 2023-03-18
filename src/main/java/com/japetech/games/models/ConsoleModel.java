package com.japetech.games.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_JPT_CONSOLE")
public class ConsoleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CONSOLE")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresa;

}
