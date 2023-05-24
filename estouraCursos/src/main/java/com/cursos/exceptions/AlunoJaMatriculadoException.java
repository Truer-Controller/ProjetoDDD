package com.cursos.exceptions;

import org.springframework.http.HttpStatus;

public class AlunoJaMatriculadoException extends Exception {

    public AlunoJaMatriculadoException(String curso) {
        super("Aluno já matriculado no curso " + curso);
    }

}
