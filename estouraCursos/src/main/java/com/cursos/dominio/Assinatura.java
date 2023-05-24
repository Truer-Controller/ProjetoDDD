package com.cursos.dominio;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Assinatura {

    BASICA("Básica", 1),
    PREMIUM("Premium", 2);

    private String descricao;
    private Integer codigo;

    private Assinatura(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public Assinatura getByDescricao(String descricao) {
        return Arrays.stream(Assinatura.values())
                .filter(a -> a.getDescricao().equals(descricao))
                .findFirst()
                .orElse(null);
    }

}
