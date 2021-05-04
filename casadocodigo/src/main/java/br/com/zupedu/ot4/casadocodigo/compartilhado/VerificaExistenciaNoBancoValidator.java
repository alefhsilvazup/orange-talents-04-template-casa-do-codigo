package br.com.zupedu.ot4.casadocodigo.compartilhado;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

public class VerificaExistenciaNoBancoValidator
        implements ConstraintValidator<VerificaExistenciaNoBanco, Object> {

    private String campoASerPesquisado;
    private Class<?> tabela;
    @PersistenceContext private EntityManager entityManager;
    @Autowired private Validator validator;
    @Override
    public void initialize(VerificaExistenciaNoBanco constraintAnnotation) {
        this.tabela = constraintAnnotation.tabela();
        this.campoASerPesquisado = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Boolean valorJaExiste = entityManager.createQuery("select count(t) < 1 from "
                + tabela.getName()
                + " t  where " + campoASerPesquisado + " = :valor", Boolean.class)
                .setParameter("valor", value)
                .getSingleResult();

        return valorJaExiste;
    }
}
