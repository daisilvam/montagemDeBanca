package edu.ifma.programacaoextrema.service;

import edu.ifma.programacaoextrema.model.Aluno;
import edu.ifma.programacaoextrema.model.Banca;
import edu.ifma.programacaoextrema.model.Orientador;
import edu.ifma.programacaoextrema.model.Portaria;
import edu.ifma.programacaoextrema.repository.OrientadorRepository;
import edu.ifma.programacaoextrema.util.exception.MontagemBancaException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancaService {
    private AlunoService alunoService = new AlunoService();
    private OrientadorRepository orientadorRepository = new OrientadorRepository();

    public Banca montaBanca(Aluno aluno) throws MontagemBancaException {
        if (alunoService.verificaAlunoApto(aluno)) {
            List<Orientador> orientadoresConvidados = convidaOrientadores();
            return new Banca(orientadoresConvidados);
        } else {
            String erro = "aluno nao pode defender tcc. Percentual minimo nao atingido.";
            throw new MontagemBancaException(erro);
        }
    }

    public List<Orientador> convidaOrientadores() throws MontagemBancaException {
        List<Orientador> orientadores = orientadorRepository.convidaProfessores();
        List<Orientador> orientadoresAptos = new ArrayList<>();

        for (Orientador orientador : orientadores) {
            if (orientador.getCurso().equals("Sistemas de Informação")) {
                orientadoresAptos.add(orientador);
            } else {
                String erro = "Orientador(es) convidado(s) não são de Sistemas de Informação.";
                throw new MontagemBancaException(erro);
            }
        }

        if (orientadoresAptos.size() == 2) {
            return orientadoresAptos;
        } else {
            String erro = "É necessário convidar 2 orientadores para banca.";
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
