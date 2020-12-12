package edu.ifma.programacaoextrema;

import edu.ifma.programacaoextrema.model.Aluno;
import edu.ifma.programacaoextrema.model.Banca;
import edu.ifma.programacaoextrema.model.Orientador;
import edu.ifma.programacaoextrema.model.Portaria;
import edu.ifma.programacaoextrema.service.BancaService;
import edu.ifma.programacaoextrema.util.exception.MontagemBancaException;

public class App {
    public static void main(String[] args) throws MontagemBancaException {
        BancaService bancaService = new BancaService();

        Orientador orientador = new Orientador();
        orientador.setId(3L);
        orientador.setMatricula("SI354654");
        orientador.setNome("Jeane Ferreira");
        orientador.setCurso("Sistemas de Informação");
        orientador.setCargo("Professor");

        Aluno aluno = new Aluno(orientador);
        aluno.setId(1L);
        aluno.setMatricula("SI164578");
        aluno.setNome("Daiane Silva");
        aluno.setCurso("Sistemas de Informação");
        aluno.atualizaPercentualConclusao(0.9);

        Banca banca = bancaService.montaBanca(aluno);
        Portaria portaria = bancaService.consultaPortaria();
        System.out.println("BANCA: " + banca.toString());
        System.out.println("PORTARIA: " + portaria);
    }
}
