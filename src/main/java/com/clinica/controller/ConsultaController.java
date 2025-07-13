package com.clinica.controller;
import com.clinica.model.Consulta;
import com.clinica.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired private ClinicaService service;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Consulta c) {
        service.agendarConsulta(c);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Consulta> all() {
        return service.listarConsultas();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Consulta> get(@PathVariable int index) {
        return service.buscarConsulta(index)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{index}")
    public ResponseEntity<Void> update(@PathVariable int index, @RequestBody Consulta c) {
        service.atualizarConsulta(index, c);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> delete(@PathVariable int index) {
        service.removerConsulta(index);
        return ResponseEntity.ok().build();
    }
}