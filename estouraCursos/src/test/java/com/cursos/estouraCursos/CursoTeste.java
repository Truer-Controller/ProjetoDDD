package com.cursos.estouraCursos;

import com.cursos.dominio.Aluno;
import com.cursos.dominio.Assinatura;
import com.cursos.dominio.Curso;
import com.cursos.dominio.Topico;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CursoTeste {

    @Test
    @SneakyThrows
    public void devePresentearUmCurso() {
        var curso = new Curso("Empilhadeira");

        var ramon = new Aluno("Ramon", Assinatura.BASICA);
        var marco = new Aluno("Marco", Assinatura.PREMIUM);
        var topicoMacaco = new Topico("O Macaco", "O segundo primata mais evoluído.");
        var topicoAlce = new Topico("O Alce", "O animal com galho na cabeça.");
        var topicoFruta = new Topico("A melancia", "A fruta verde e oval.");

        ramon.matricular(curso);
        marco.matricular(curso);
        curso.criarTopicos(topicoMacaco, topicoAlce, topicoFruta);

        var comentarioUmRamon = ramon.comentar(topicoMacaco, "Interessante");
        comentarioUmRamon.avaliar(true);
        marco.comentar(topicoMacaco, "Uau");
        var comentarioUmMarco = marco.comentar(topicoAlce, "Hmmm");
        comentarioUmMarco.avaliar(true);
        ramon.comentar(topicoAlce, "É...");
        var comentarioDoisMarco = marco.comentar(topicoFruta, "Legal");
        comentarioDoisMarco.avaliar(true);

        assertTrue(curso.isUltimoDiaDoMes());
        assertEquals(curso.getAlunoComMaiorContribuicao(), marco);
    }
}
