package com.cursos.estouraCursos;

import com.cursos.dominio.Aluno;
import com.cursos.dominio.Assinatura;
import com.cursos.dominio.Comentario;
import com.cursos.dominio.Curso;
import com.cursos.dominio.Topico;

import org.junit.Test;

import static org.junit.Assert.*;


public class TopicoTeste {

    @Test
    public void deveCriarUmTopicoSemComentarios() {
        var topico = new Topico("Cuidados na Indústria", "Como não tomar choque usando EPIs");

        assertTrue(topico.getComentarios().isEmpty());
    }

    @Test
    public void deveCriarUmComentarioNoComentario() throws Exception {
        var milton = new Aluno("Milton", Assinatura.BASICA);
        var marquin = new Aluno("Marquin", Assinatura.BASICA);
        var topico = new Topico("Carros movidos à... pés?", "Os Flintstones");
        var curso = new Curso("Ortopedista");

        milton.matricular(curso);
        marquin.matricular(curso);
        curso.criarTopico(topico);
        var comentario = milton.comentar(topico, "Será que existia chinelo na época?");
        comentario.comentarComentario(topico, comentario, new Comentario(marquin, topico,"Só se for de pedra."));
        assertTrue(!comentario.getComentarios().isEmpty());
        assertTrue(comentario.getComentarios().get(0).getDescricao().contains("pedra"));
    }
}
