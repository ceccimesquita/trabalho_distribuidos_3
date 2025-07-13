package com.clinica.controller;
import com.clinica.model.Paciente;
import com.clinica.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired private ClinicaService service;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Paciente p) {
        service.adicionarPaciente(p);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Paciente> all() {
        return service.listarPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> get(@PathVariable String id) {
        return service.buscarPacientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Paciente p) {
        service.atualizarPaciente(id, p);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.removerPaciente(id);
        return ResponseEntity.ok().build();
    }
}