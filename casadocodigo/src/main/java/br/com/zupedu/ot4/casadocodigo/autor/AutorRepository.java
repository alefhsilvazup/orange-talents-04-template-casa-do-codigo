package br.com.zupedu.ot4.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

    boolean existsByEmail(String email);
}
