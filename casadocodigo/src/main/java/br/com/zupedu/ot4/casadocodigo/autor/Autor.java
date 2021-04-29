package br.com.zupedu.ot4.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String introducao;

    @CreationTimestamp
    private LocalDateTime criadoEm = LocalDateTime.now(ZoneOffset.UTC);

    public Autor(String nome, String email, String introducao) {
        this.nome = nome;
        this.email = email;
        this.introducao = introducao;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + introducao + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }

    public LocalDateTime getCriadoEm() {
        return this.criadoEm;
    }
}
