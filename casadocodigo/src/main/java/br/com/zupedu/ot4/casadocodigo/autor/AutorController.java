package br.com.zupedu.ot4.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/autores")
    public ResponseEntity<?> cadastraAutor(@RequestBody @Valid AutorRequest request) {
        System.out.println("autor: " + request.toString());
        Autor autor = request.seTransformaNoModelo();
        System.out.println("tudo funcionando belezinha! " + LocalDateTime.now());
        autorRepository.save(autor);
        return ResponseEntity.ok(autor.toString());
    }
}
