package edu.ifma.programacaoextrema.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Portaria {
    private LocalDateTime dataHorario;
    private String local;
}
