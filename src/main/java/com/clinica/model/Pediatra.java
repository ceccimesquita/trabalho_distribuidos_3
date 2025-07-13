package com.clinica.model;

import com.clinica.model.Medico;
import lombok.Data;

@Data
public class Pediatra extends Medico {
    private String faixaEtariaAtendida;
    private boolean possuiEspecializacaoNeonatal;

    public Pediatra() {}
    public Pediatra(String nome, String crm, String contato,
                    String faixaEtariaAtendida, boolean possuiEspecializacaoNeonatal) {
        super(nome, crm, contato);
        this.faixaEtariaAtendida = faixaEtariaAtendida;
        this.possuiEspecializacaoNeonatal = possuiEspecializacaoNeonatal;
    }

    @Override
    public String toString() {
        return "Pediatra{" +
                "nome='" + getNome() + '\'' +
                ", crm='" + getCrm() + '\'' +
                ", contato='" + getContato() + '\'' +
                ", faixaEtariaAtendida='" + faixaEtariaAtendida + '\'' +
                ", neonatal=" + possuiEspecializacaoNeonatal +
                '}';
    }
}