package com.cursos.usecases;

import java.util.Optional;

import com.cursos.dominio.Curso;
import com.cursos.dto.CursoDTO;
import com.cursos.factory.CursoFactory;
import com.cursos.repository.CursoRepository;

public class CursoUseCase {
	
    private CursoRepository cursoRepository;

    public CursoUseCase(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoDTO criarCurso(CursoDTO dto) {
        Curso curso = CursoFactory.createFromDTO(dto);
        cursoRepository.save(curso);
        return cursoToDTO(curso);
    }

    public CursoDTO obterCurso(String nome) {
        Curso curso = cursoRepository.findByNome(nome);
        return cursoToDTO(curso);
    }

    private CursoDTO cursoToDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setEmail(curso.getEmail());
        dto.setMateria(curso.getMateria());
        return dto;
    }
}
