package com.clinica.controller;
import com.clinica.model.Medico;
import com.clinica.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    @Autowired private ClinicaService service;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Medico m) {
        service.adicionarMedico(m);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Medico> all() {
        return service.listarMedicos();
    }

    @GetMapping("/{crm}")
    public ResponseEntity<Medico> get(@PathVariable String crm) {
        return service.buscarMedicoPorCrm(crm)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{crm}")
    public ResponseEntity<Void> update(@PathVariable String crm, @RequestBody Medico m) {
        service.atualizarMedico(crm, m);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{crm}")
    public ResponseEntity<Void> delete(@PathVariable String crm) {
        service.removerMedico(crm);
        return ResponseEntity.ok().build();
    }
}