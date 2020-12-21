package edu.ifma.programacaoextrema.repository;

import edu.ifma.programacaoextrema.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    public List<Professor> convidaProfessores(){
        List<Professor> professores = new ArrayList<>();

        Professor professor = new Professor();
        professor.setId(1L);
        professor.setMatricula("SI123456");
        professor.setNome("Mauro Lopes");
        professor.setCurso("Sistemas de Informação");
        professores.add(professor);

        professor = new Professor();
        professor.setId(2L);
        professor.setMatricula("SI143457");
        professor.setNome("Osvaldo Vieira");
        professor.setCurso("Sistemas de Informação");
        professores.add(professor);

        return professores;
    }
}
