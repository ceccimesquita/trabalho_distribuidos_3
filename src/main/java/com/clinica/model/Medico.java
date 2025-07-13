package com.clinica.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Ortopedista.class, name = "ortopedista"),
        @JsonSubTypes.Type(value = Pediatra.class,    name = "pediatra"),
        @JsonSubTypes.Type(value = Psiquiatra.class, name = "psiquiatra")
})
public abstract class Medico implements Serializable {
    private String nome;
    private String crm;
    private String contato;

    public Medico() {}
    public Medico(String nome, String crm, String contato) {
        this.nome = nome;
        this.crm = crm;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}