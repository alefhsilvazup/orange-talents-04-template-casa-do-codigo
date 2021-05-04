package br.com.zupedu.ot4.casadocodigo.autor;

import br.com.zupedu.ot4.casadocodigo.compartilhado.CpnjOuCPF;
import br.com.zupedu.ot4.casadocodigo.compartilhado.VerificaExistenciaNoBanco;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

class PaisEstadoRequest {
    private Long idPais;
    private Long idEstado;


}

public class AutorRequest {

    private @NotBlank @Length(min = 3) String nome;
    private @VerificaExistenciaNoBanco(campo = "email", tabela = Autor.class)
    @NotBlank @Email String email;
    private @NotBlank @Length(min = 10, max = 400) String descricao;

    private String cnpjOucpf;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor seTransformaNoModelo() {
        return new Autor(this.nome, this.email, descricao);
    }

    public String getEmail() {
        return email;
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
