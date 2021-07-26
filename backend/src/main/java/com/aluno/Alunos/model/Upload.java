package com.aluno.Alunos.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="UPLOAD")
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Value("${scitc.upload.src}")
    private String rootPath;

    @Value("${scitc.upload.host}")
    private String uploadhost;

}
