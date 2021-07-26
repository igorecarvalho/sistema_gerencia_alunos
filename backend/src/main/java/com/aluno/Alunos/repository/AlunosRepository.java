package com.aluno.Alunos.repository;

import com.aluno.Alunos.model.Alunos;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {

    Alunos findFirstById(Long id);
}
