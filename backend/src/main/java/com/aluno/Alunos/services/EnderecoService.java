package com.aluno.Alunos.services;

import com.aluno.Alunos.model.Endereco;
import com.aluno.Alunos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin(origins = "*")
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco cadastrar(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public Endereco getEndereco(Long id){

        return enderecoRepository.findFirstById(id);
    }

    public Endereco editar(Endereco endereco){

        return enderecoRepository.save(endereco);
    }
}
