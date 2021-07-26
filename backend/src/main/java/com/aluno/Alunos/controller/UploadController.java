package com.aluno.Alunos.controller;

import com.aluno.Alunos.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alunos")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @CrossOrigin
    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        return new ResponseEntity<>(uploadService.uploadFile(file), HttpStatus.OK);
    }
}
