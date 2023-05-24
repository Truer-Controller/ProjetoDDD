package com.cursos.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cursos.dominio.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nome);
	
}
