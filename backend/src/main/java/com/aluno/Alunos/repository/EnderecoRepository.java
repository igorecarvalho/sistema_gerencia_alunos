package com.aluno.Alunos.repository;

import com.aluno.Alunos.model.Endereco;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findFirstById(Long id);
}
