package com.cursos.dominio;

import com.cursos.exceptions.AlunoJaMatriculadoException;
import com.cursos.exceptions.AlunoNaoPertenceAoCursoException;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Aluno {

    private String nome;
    private Assinatura assinatura;
    private Integer moedas;
    private Map<Curso, Float> cursosMatriculados;
    private List<Comentario> comentarios;

    public Aluno(String nome, Assinatura assinatura){
        this.nome = nome;
        this.assinatura = assinatura;
        this.moedas = 0;
        this.comentarios = new ArrayList<Comentario>();
        this.cursosMatriculados = new HashMap<Curso, Float>();
    }

    public void matricular(Curso curso) throws Exception {
        if(Objects.nonNull(this.cursosMatriculados.get(curso))) {
            throw new AlunoJaMatriculadoException(curso.getMateria());
        }
        this.cursosMatriculados.put(curso, -1F);
        curso.matricularAluno(this);
    }

    @SneakyThrows
    public Comentario comentar(Topico topico, String mensagem) {
        this.validarAlunoMatriculadoNoCurso(this, topico);
        var comentario = new Comentario(this, topico, mensagem);
        topico.getComentarios().add(comentario);

        return comentario;
    }

    @SneakyThrows
    public static void validarAlunoMatriculadoNoCurso(Aluno aluno, Topico topico) {
        if(!aluno.getCursosMatriculados().containsKey(topico.getCurso())){
            throw new AlunoNaoPertenceAoCursoException();
        }
    }

}
