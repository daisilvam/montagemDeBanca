package edu.ifma.programacaoextrema.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String nome;
    private Double percentualConclusao;
    private String curso;
    private boolean apto;

    @ManyToOne
    private Professor professor;

    public Aluno(Professor professor) {
        this.setProfessor(professor);
    }

    public void atualizaPercentualConclusao(Double percentualConclusao){
        if(percentualConclusao >= 0.9) {
            this.setApto(true);
        } else {
            this.setApto(false);
        }
        this.setPercentualConclusao(percentualConclusao);
    }

}
