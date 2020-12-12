package edu.ifma.programacaoextrema.model;

import lombok.Data;

import java.util.List;

@Data
public class Banca {
    private List<Orientador> orientadores;
    private boolean finalizada;

    public Banca(List<Orientador> orientadores) {
        this.orientadores = orientadores;
    }

    public String toString() {
        return "Orientadores: " + this.orientadores;
    }

}
