package com.aluno.Alunos.controller;

import com.aluno.Alunos.model.Alunos;
import com.aluno.Alunos.services.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    AlunosService alunosService;

    @CrossOrigin
    @GetMapping("/listarAlunos")
    public ResponseEntity<List> listarTodos(){

        return new ResponseEntity<>(alunosService.listar(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{idAluno}/listar")
    public ResponseEntity<Alunos> listarPorId(@PathVariable(value = "idAluno") Long idAluno){

        return new ResponseEntity<>(alunosService.getAlunos(idAluno), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<Alunos> cadastrar(@RequestBody Alunos aluno){

        return new ResponseEntity<>(alunosService.cadastrar(aluno), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{idAluno}/editar")
    public ResponseEntity<Alunos> editar(@RequestBody Alunos aluno){

        return new ResponseEntity<>(alunosService.editar(aluno), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{idAluno}/deletar")
    public void deletar(@PathVariable(value = "idAluno") Long idAluno){

        alunosService.deletar(idAluno);
    }
}

