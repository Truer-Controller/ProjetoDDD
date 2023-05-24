package com.cursos.exceptions;

public class AlunoNaoPertenceAoCursoException extends Exception {

    public AlunoNaoPertenceAoCursoException() {
        super("O aluno não está matriculado neste curso.");
    }
}
