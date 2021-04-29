package br.com.zupedu.ot4.casadocodigo.autor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class AutorController {


    @PostMapping("/autores")
    public void cadastraAutor(@RequestBody @Valid AutorRequest request) {
        System.out.println("autor: " + request.toString());
        Autor autor = request.seTransformaNoModelo();
        System.out.println("tudo funcionando belezinha! " + LocalDateTime.now());

    }
}
