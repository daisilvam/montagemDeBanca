package edu.ifma.programacaoextrema.service;

import edu.ifma.programacaoextrema.model.Aluno;
import edu.ifma.programacaoextrema.model.Banca;
import edu.ifma.programacaoextrema.model.Professor;
import edu.ifma.programacaoextrema.model.Portaria;
import edu.ifma.programacaoextrema.repository.ProfessorRepository;
import edu.ifma.programacaoextrema.util.exception.MontagemBancaException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancaService {
    private AlunoService alunoService = new AlunoService();
    private ProfessorRepository professorRepository = new ProfessorRepository();

    public Banca montaBanca(Aluno aluno) throws MontagemBancaException {
        if (alunoService.verificaAlunoApto(aluno)) {
            List<Professor> professoresConvidados = convidaProfessores();
            return new Banca(professoresConvidados);
        } else {
            String erro = "aluno nao pode defender tcc. Percentual minimo nao atingido.";
            throw new MontagemBancaException(erro);
        }
    }

    public List<Professor> convidaProfessores() throws MontagemBancaException {
        List<Professor> professores = professorRepository.convidaProfessores();
        List<Professor> professoresAptos = new ArrayList<>();

        for (Professor professor : professores) {
            if (professor.getCurso().equals("Sistemas de Informação")) {
                professoresAptos.add(professor);
            } else {
                String erro = "Orientador(es) convidado(s) não são de Sistemas de Informação.";
                throw new MontagemBancaException(erro);
            }
        }

        if (professoresAptos.size() == 2) {
            return professoresAptos;
        } else {
            String erro = "É necessário convidar 2 professores para banca.";
            throw new MontagemBancaException(erro);
        }
    }

    public Portaria consultaPortaria() {
        LocalDateTime dataHorario = LocalDateTime.now().plusWeeks(2);
        String local = "Auditorio Florise Perola";
        Portaria portaria = new Portaria();
        portaria.setDataHorario(dataHorario);
        portaria.setLocal(local);
        return portaria;
    }
}
