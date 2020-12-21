package edu.ifma.programacaoextrema.repository;

import edu.ifma.programacaoextrema.model.Orientador;

import java.util.ArrayList;
import java.util.List;

public class OrientadorRepository {
    public List<Orientador> convidaProfessores(){
        List<Orientador> orientadores = new ArrayList<>();

        Orientador orientador = new Orientador();
        orientador.setId(1L);
        orientador.setMatricula("SI123456");
        orientador.setNome("Mauro Lopes");
        orientador.setCurso("Sistemas de Informação");
        orientador.setCargo("Professor");
        orientadores.add(orientador);

        orientador = new Orientador();
        orientador.setId(2L);
        orientador.setMatricula("SI143457");
        orientador.setNome("Osvaldo Vieira");
        orientador.setCurso("Sistemas de Informação");
        orientador.setCargo("Professor");
        orientadores.add(orientador);

        return orientadores;
    }
}
