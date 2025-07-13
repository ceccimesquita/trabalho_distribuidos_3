package com.clinica.service;

import com.clinica.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClinicaService {
    private final List<Medico> medicos = new ArrayList<>();
    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<Consulta> consultas = new ArrayList<>();

    public void adicionarMedico(Medico m) { medicos.add(m); }
    public List<Medico> listarMedicos() { return List.copyOf(medicos); }
    public Optional<Medico> buscarMedicoPorCrm(String crm) {
        return medicos.stream().filter(m -> m.getCrm().equals(crm)).findFirst();
    }
    public void atualizarMedico(String crm, Medico m) {
        buscarMedicoPorCrm(crm).ifPresent(orig -> {
            medicos.remove(orig);
            medicos.add(m);
        });
    }
    public void removerMedico(String crm) {
        medicos.removeIf(m -> m.getCrm().equals(crm));
    }

    public void adicionarPaciente(Paciente p) { pacientes.add(p); }
    public List<Paciente> listarPacientes() { return List.copyOf(pacientes); }
    public Optional<Paciente> buscarPacientePorId(String id) {
        return pacientes.stream().filter(p -> p.getIdPaciente().equals(id)).findFirst();
    }
    public void atualizarPaciente(String id, Paciente p) {
        buscarPacientePorId(id).ifPresent(orig -> {
            pacientes.remove(orig);
            pacientes.add(p);
        });
    }
    public void removerPaciente(String id) {
        pacientes.removeIf(p -> p.getIdPaciente().equals(id));
    }

    public void agendarConsulta(Consulta c) { consultas.add(c); }
    public List<Consulta> listarConsultas() { return List.copyOf(consultas); }
    public Optional<Consulta> buscarConsulta(int index) {
        return index >= 0 && index < consultas.size() ? Optional.of(consultas.get(index)) : Optional.empty();
    }
    public void atualizarConsulta(int index, Consulta c) {
        if (index >= 0 && index < consultas.size()) consultas.set(index, c);
    }
    public void removerConsulta(int index) {
        if (index >= 0 && index < consultas.size()) consultas.remove(index);
    }
}