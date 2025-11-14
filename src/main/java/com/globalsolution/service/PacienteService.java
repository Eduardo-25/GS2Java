package com.globalsolution.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalsolution.dto.PacienteRequestDTO;
import com.globalsolution.dto.PacienteResponseDTO;
import com.globalsolution.entity.Paciente;
import com.globalsolution.exception.BadRequestException;
import com.globalsolution.exception.ResourceNotFoundException;
import com.globalsolution.mapper.PacienteMapper;
import com.globalsolution.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<PacienteResponseDTO> findAll() {
        return pacienteRepository.findAll().stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PacienteResponseDTO findById(Long id) {
        Paciente p = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));
        return PacienteMapper.toDTO(p);
    }

    @Transactional
    public PacienteResponseDTO create(PacienteRequestDTO dto) {
        String email = dto.getEmail() == null ? null : dto.getEmail().trim();
        if (email == null || email.isBlank()) {
            throw new BadRequestException("Email é obrigatório");
        }

        boolean exists = pacienteRepository.findByEmail(email.toLowerCase()).isPresent();
        if (exists) {
            throw new BadRequestException("Email já cadastrado: " + email);
        }

        Paciente p = PacienteMapper.toEntity(dto);
        p.setEmail(email.toLowerCase());

        Paciente saved = pacienteRepository.save(p);
        return PacienteMapper.toDTO(saved);
    }

    @Transactional
    public PacienteResponseDTO update(Long id, PacienteRequestDTO dto) {
        Paciente p = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));

        String newEmail = dto.getEmail() == null ? null : dto.getEmail().trim();
        if (newEmail != null && !newEmail.isBlank()) {
            pacienteRepository.findByEmail(newEmail.toLowerCase())
                    .ifPresent(existing -> {
                        if (!existing.getId().equals(id)) {
                            throw new BadRequestException("Email já cadastrado por outro paciente: " + newEmail);
                        }
                    });
            dto.setEmail(newEmail.toLowerCase());
        }

        PacienteMapper.updateEntityFromDTO(dto, p);
        Paciente saved = pacienteRepository.save(p);
        return PacienteMapper.toDTO(saved);
    }

    public void delete(Long id) {
        Paciente p = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));
        pacienteRepository.delete(p);
    }

    public Paciente findEntityById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));
    }
}
