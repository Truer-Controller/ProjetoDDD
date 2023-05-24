package com.cursos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.dto.CursoDTO;
import com.cursos.usecases.CursoUseCase;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	
	    private CursoUseCase cursoUseCase;

	    public CursoController(CursoUseCase cursoUseCase) {
	        this.cursoUseCase = cursoUseCase;
	    }

	    @PostMapping
	    public ResponseEntity<CursoDTO> criarCurso(@RequestBody CursoDTO dto) {
	        CursoDTO createdCurso = cursoUseCase.criarCurso(dto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCurso);
	    }

	    @GetMapping("/{nome}")
	    public ResponseEntity<CursoDTO> obterCurso(@PathVariable("nome") String nome) {
	        CursoDTO curso = cursoUseCase.obterCurso(nome);
	        if (curso != null) {
	            return ResponseEntity.ok(curso);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
