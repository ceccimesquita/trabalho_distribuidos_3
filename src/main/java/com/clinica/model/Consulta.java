package com.clinica.model;

import com.clinica.model.Medico;
import com.clinica.model.Paciente;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Consulta implements Serializable {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime dataHora;

    public Consulta() {}
    public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora) {
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "medico=" + medico +
                ", paciente=" + paciente +
                ", dataHora=" + dataHora +
                '}';
    }
}