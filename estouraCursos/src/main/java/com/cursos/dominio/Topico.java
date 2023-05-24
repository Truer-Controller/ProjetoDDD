package com.cursos.dominio;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Topico {

    private String titulo;
    private String descricao;
    private List<Comentario> comentarios;
    private Curso curso;

    public Topico(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.comentarios = new ArrayList<Comentario>();
    }

}
