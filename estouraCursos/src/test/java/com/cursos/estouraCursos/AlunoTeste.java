package com.cursos.estouraCursos;

import com.cursos.dominio.Aluno;
import com.cursos.dominio.Assinatura;
import com.cursos.dominio.Curso;
import com.cursos.dominio.Topico;
import com.cursos.exceptions.AlunoJaMatriculadoException;
import com.cursos.exceptions.AlunoNaoPertenceAoCursoException;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.*;


public class AlunoTeste {

    @Test
    public void deveCriarAlunoComZeroMoedas() {
        var aluno = new Aluno("Rodimar", Assinatura.BASICA);

        assertEquals(aluno.getMoedas(), Integer.valueOf(0));
    }

    @Test
    @SneakyThrows
    public void deveMatricularAlunoNoCurso() {
        var aluno = new Aluno("Rodimar", Assinatura.BASICA);
        var curso = new Curso("Elétrica");

        aluno.matricular(curso);

        assertTrue(curso.getAlunos().contains(aluno));
    }

    @Test
    @SneakyThrows
    public void naoDeveMatricularAlunoNoCursoJaMatriculado() throws Exception {
        var aluno = new Aluno("Rodimar", Assinatura.BASICA);
        var curso = new Curso("Elétrica");

        aluno.matricular(curso);
        assertThrows(AlunoJaMatriculadoException.class, () -> {
            aluno.matricular(curso);
        });
    }

}
