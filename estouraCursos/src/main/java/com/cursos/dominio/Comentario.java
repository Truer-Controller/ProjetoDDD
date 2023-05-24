package com.cursos.dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Comentario {

    private String descricao;
    private Aluno aluno;
    private Integer avaliacao;
    private List<Comentario> comentarios;
    private Topico topico;

    public Comentario(Aluno aluno, Topico topico, String descricao) {
        this.aluno = aluno;
        this.descricao = descricao;
        this.avaliacao = 0;
        this.comentarios = new ArrayList<Comentario>();
        this.topico = topico;
    }

    @SneakyThrows
    public void comentarComentario(Topico topico, Comentario comentario, Comentario resposta) {
        Aluno.validarAlunoMatriculadoNoCurso(resposta.getAluno(), topico);
        comentario.getComentarios().add(resposta);
    }

    public void avaliar(Boolean avaliacao) {
        this.avaliacao += avaliacao ? 1 : -1;
    }

}
