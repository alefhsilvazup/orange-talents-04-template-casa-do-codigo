package br.com.zupedu.ot4.casadocodigo.autor;

import br.com.zupedu.ot4.casadocodigo.compartilhado.VerificaExistenciaNoBanco;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String introducao;

    @CreationTimestamp
    private LocalDateTime criadoEm = LocalDateTime.now(ZoneOffset.UTC);

    @Deprecated
    /**
     * somente o hibernate deve usar essa bagaça
     */
    public Autor(){};


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
