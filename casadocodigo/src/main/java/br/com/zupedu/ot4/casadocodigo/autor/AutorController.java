package br.com.zupedu.ot4.casadocodigo.autor;

import br.com.zupedu.ot4.casadocodigo.compartilhado.CampoUnicoComSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @InitBinder
    public void validacao(WebDataBinder binder) {
        CampoUnicoComSpring<AutorRequest, String> validadorEmailUnico =
                new CampoUnicoComSpring<>("email", AutorRequest.class,
                autorRepository::existsByEmail);
        binder.addValidators(validadorEmailUnico);
    }

}
