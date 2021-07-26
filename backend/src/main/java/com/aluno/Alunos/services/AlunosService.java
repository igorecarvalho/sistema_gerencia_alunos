package com.aluno.Alunos.services;

import com.aluno.Alunos.model.Alunos;
import com.aluno.Alunos.repository.AlunosRepository;
import com.aluno.Alunos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class AlunosService {

    @Autowired
    AlunosRepository alunosRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Alunos> listar(){

        return alunosRepository.findAll();
    }

    public Alunos cadastrar(Alunos aluno){

        enderecoRepository.save(aluno.getEndereco());
        return alunosRepository.save(aluno);
    }

    public Alunos getAlunos(Long id){

        return alunosRepository.findFirstById(id);
    }

    public Alunos editar(Alunos aluno){

        return alunosRepository.save(aluno);
    }

    public void deletar(Long id){

        Alunos aluno = alunosRepository.findFirstById(id);
        alunosRepository.delete(aluno);
    }
}
