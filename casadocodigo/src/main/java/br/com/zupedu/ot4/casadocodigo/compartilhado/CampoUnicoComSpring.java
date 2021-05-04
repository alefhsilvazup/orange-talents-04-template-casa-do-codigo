package br.com.zupedu.ot4.casadocodigo.compartilhado;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.Field;
import java.util.function.Function;


public class CampoUnicoComSpring<T, P> implements Validator {

    private String campo;
    private Class<? extends T> classeParaSerValidada;
    private Function<P, Boolean> metodoQueVaiNoBanco;

    @Override
    public void validate(Object o, Errors errors) {
        //O que precisamos fazer?
        // Ir no banco de dados verifica se o objeto existe -> Repository
        // de um método retorna boolean

        try {
            Field declaredField = classeParaSerValidada.getDeclaredField(this.campo);
            declaredField.setAccessible(true);
            Object valorASerPesquisado = declaredField.get(o);
            Boolean existeNoBanco = metodoQueVaiNoBanco.apply((P) valorASerPesquisado);

            if(existeNoBanco) {
                errors.rejectValue(campo, "campoUnico", "O campo deve ser unico no banco");
            }

        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }



    }

    public CampoUnicoComSpring(String campo,
                               Class<? extends T> classeParaSerValidada,
                               Function<P, Boolean> metodoQueVaiNoBanco) {
        this.campo = campo;
        this.classeParaSerValidada = classeParaSerValidada;
        this.metodoQueVaiNoBanco = metodoQueVaiNoBanco;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return this.classeParaSerValidada.isAssignableFrom(aClass);
    }
}
