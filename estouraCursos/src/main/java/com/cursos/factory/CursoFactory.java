package com.cursos.factory;

import com.cursos.dominio.Curso;
import com.cursos.dto.CursoDTO;

public class CursoFactory {
	 
	public static Curso createFromDTO(CursoDTO dto) {
	        Curso curso = new Curso();
	        curso.setMateria(dto.getMateria());
	        curso.setEmail(dto.getEmail());
	        return curso;
	    }
}
