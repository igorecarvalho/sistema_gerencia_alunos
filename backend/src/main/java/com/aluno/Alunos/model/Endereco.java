package com.aluno.Alunos.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Alunos aluno;

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;
}
