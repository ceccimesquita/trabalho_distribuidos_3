package com.clinica.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Paciente implements Serializable {
    private String nome;
    private String idPaciente;
    private String contato;

    public Paciente() {}
    public Paciente(String nome, String idPaciente, String contato) {
        this.nome = nome;
        this.idPaciente = idPaciente;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", id='" + idPaciente + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}