package com.globalsolution.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalsolution.dto.RegistroDiarioRequestDTO;
import com.globalsolution.dto.RegistroDiarioResponseDTO;
import com.globalsolution.service.RegistroDiarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/registros")
public class RegistroDiarioController {

    private final RegistroDiarioService registroService;

    public RegistroDiarioController(RegistroDiarioService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroDiarioResponseDTO>> getAll() {
        return ResponseEntity.ok(registroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.findById(id));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<RegistroDiarioResponseDTO>> getByPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(registroService.findByPacienteId(pacienteId));
    }

    @PostMapping
    public ResponseEntity<RegistroDiarioResponseDTO> create(@Valid @RequestBody RegistroDiarioRequestDTO dto) {
        RegistroDiarioResponseDTO created = registroService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> update(@PathVariable Long id, @Valid @RequestBody RegistroDiarioRequestDTO dto) {
        return ResponseEntity.ok(registroService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        registroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
