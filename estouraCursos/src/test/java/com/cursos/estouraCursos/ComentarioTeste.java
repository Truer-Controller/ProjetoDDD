package com.cursos.estouraCursos;

import com.cursos.dominio.Aluno;
import com.cursos.dominio.Assinatura;
import com.cursos.dominio.Curso;
import com.cursos.dominio.Topico;
import com.cursos.exceptions.AlunoNaoPertenceAoCursoException;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

public class ComentarioTeste {

    @Test
    @SneakyThrows
    public void naoDeveComentarNoTopicoSemOCurso() {
        var aluno = new Aluno("Rodimar", Assinatura.BASICA);
        var topico = new Topico("Macarrão instantâneo", "Os maus de alimentos industrializados");
        var curso = new Curso("Nutrição");

        curso.criarTopico(topico);

        assertThrows(AlunoNaoPertenceAoCursoException.class, () -> {
            aluno.comentar(topico, "Achei útil, obrigado, me ajudou bastante!");
        });
    }

    @Test
    @SneakyThrows
    public void deveAvaliarUmComentario() {
        var ramon = new Aluno("Ramon", Assinatura.BASICA);
        var topico = new Topico("Chave inglesa: Origem", "Onde nasceu a chave mais famosa do mundo.");
        var curso = new Curso("Engenharia Mecânica");

        curso.criarTopico(topico);
        ramon.matricular(curso);
        Random random = new Random();

        var comentario = ramon.comentar(topico, "Acho que a data de criação está errada, a correta seria 2037.");
        comentario.avaliar(random.nextBoolean());
        assertNotEquals(comentario.getAvaliacao(), Integer.valueOf(0));
    }
}
