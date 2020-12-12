package edu.ifma.programacaoextrema.service;

import edu.ifma.programacaoextrema.model.Aluno;

public class AlunoService {
    public boolean verificaAlunoApto(Aluno aluno) {
        return aluno.isApto();
    }
}
