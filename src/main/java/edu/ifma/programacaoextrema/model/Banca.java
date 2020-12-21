package edu.ifma.programacaoextrema.model;

import lombok.Data;

import java.util.List;

@Data
public class Banca {
    private List<Professor> orientadores;
    private boolean finalizada;

    public Banca(List<Professor> orientadores) {
        this.orientadores = orientadores;
    }

    public String toString() {
        return "Professores: " + this.orientadores;
    }

}
