package com.clinica.model;

import com.clinica.model.Medico;
import lombok.Data;

@Data
public class Psiquiatra extends Medico {
    private boolean atendeOnline;
    private int duracaoConsultaMin;

    public Psiquiatra() {}
    public Psiquiatra(String nome, String crm, String contato,
                      boolean atendeOnline, int duracaoConsultaMin) {
        super(nome, crm, contato);
        this.atendeOnline = atendeOnline;
        this.duracaoConsultaMin = duracaoConsultaMin;
    }

    @Override
    public String toString() {
        return "Psiquiatra{" +
                "nome='" + getNome() + '\'' +
                ", atendeOnline=" + atendeOnline +
                ", duracaoMin=" + duracaoConsultaMin +
                '}';
    }
}