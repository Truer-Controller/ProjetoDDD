package com.cursos.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

@Getter
@Setter
@Entity
public class Curso {

    private String materia;
    private Email email;
    private List<Aluno> alunos;
    private List<Topico> topicos;

    public Curso(String materia) {
        this.materia = materia;
        this.alunos = new ArrayList<Aluno>();
        this.topicos = new ArrayList<Topico>();
    }

    public Curso() {
    	
    }
    public void matricularAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void criarTopico(Topico topico) {
        topico.setCurso(this);
        this.topicos.add(topico);
    }

    public void criarTopicos(Topico... topicos) {
        for (Topico top : topicos) {
            top.setCurso(this);
            this.topicos.add(top);
        }
    }

    public Aluno getAlunoComMaiorContribuicao() {
        Map<Aluno, Integer> alunosMap = this.getAlunos().stream()
                .collect(Collectors.toMap(Function.identity(),a -> Integer.valueOf(0)));
        this.getTopicos().stream().forEach(t -> {
            var melhorAlunoDoTopico = t.getComentarios().stream()
                    .sorted(Comparator.comparingInt(Comentario::getAvaliacao).reversed())
                    .map(Comentario::getAluno)
                    .findFirst().orElse(null);
            alunosMap.put(melhorAlunoDoTopico, alunosMap.get(melhorAlunoDoTopico) + 1);

        });

        return alunosMap.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get().getKey();
    }

    public boolean isUltimoDiaDoMes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int lastDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return Objects.equals(LocalDate.now().getDayOfMonth(),lastDayMonth);
    }









}
