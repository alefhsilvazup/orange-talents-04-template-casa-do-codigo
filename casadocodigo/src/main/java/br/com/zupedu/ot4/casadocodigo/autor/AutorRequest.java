package br.com.zupedu.ot4.casadocodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AutorRequest {

    private @NotBlank @Length(min = 3) String nome;
    private @NotBlank @Email String email;
    private @NotBlank @Length(min = 10, max = 400) String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor seTransformaNoModelo() {
        return new Autor(this.nome, this.email, descricao);
    }

    @Override
    public String toString() {
        return "AutorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
