package com.clinica.model;

import com.clinica.model.Medico;
import lombok.Data;

@Data
public class Ortopedista extends Medico {
    private String areaEspecializada;
    private boolean realizaCirurgia;

    public Ortopedista() {}
    public Ortopedista(String nome, String crm, String contato,
                       String areaEspecializada, boolean realizaCirurgia) {
        super(nome, crm, contato);
        this.areaEspecializada = areaEspecializada;
        this.realizaCirurgia = realizaCirurgia;
    }

    @Override
    public String toString() {
        return "Ortopedista{" +
                "nome='" + getNome() + '\'' +
                ", crm='" + getCrm() + '\'' +
                ", contato='" + getContato() + '\'' +
                ", area='" + areaEspecializada + '\'' +
                ", cirurgia=" + realizaCirurgia +
                '}';
    }
}