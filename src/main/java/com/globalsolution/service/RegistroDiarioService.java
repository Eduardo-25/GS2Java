package com.globalsolution.service;

import com.globalsolution.dto.RegistroDiarioRequestDTO;
import com.globalsolution.dto.RegistroDiarioResponseDTO;
import com.globalsolution.entity.Paciente;
import com.globalsolution.entity.RegistroDiario;
import com.globalsolution.exception.ResourceNotFoundException;
import com.globalsolution.mapper.RegistroDiarioMapper;
import com.globalsolution.repository.RegistroDiarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroDiarioService {

    private final RegistroDiarioRepository registroRepo;
    private final PacienteService pacienteService;

    public RegistroDiarioService(RegistroDiarioRepository registroRepo, PacienteService pacienteService) {
        this.registroRepo = registroRepo;
        this.pacienteService = pacienteService;
    }

    public List<RegistroDiarioResponseDTO> findAll() {
        return registroRepo.findAll().stream()
                .map(RegistroDiarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RegistroDiarioResponseDTO findById(Long id) {
        RegistroDiario r = registroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id " + id));
        return RegistroDiarioMapper.toDTO(r);
    }

    @Transactional
    public RegistroDiarioResponseDTO create(RegistroDiarioRequestDTO dto) {
        Paciente paciente = pacienteService.findEntityById(dto.getPacienteId());
        RegistroDiario r = RegistroDiarioMapper.toEntity(dto, paciente);
        RegistroDiario saved = registroRepo.save(r);
        return RegistroDiarioMapper.toDTO(saved);
    }

    @Transactional
    public RegistroDiarioResponseDTO update(Long id, RegistroDiarioRequestDTO dto) {
        RegistroDiario r = registroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id " + id));
        Paciente paciente = pacienteService.findEntityById(dto.getPacienteId());
        RegistroDiarioMapper.updateEntityFromDTO(dto, r);
        r.setPaciente(paciente);
        RegistroDiario saved = registroRepo.save(r);
        return RegistroDiarioMapper.toDTO(saved);
    }

    public void delete(Long id) {
        RegistroDiario r = registroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id " + id));
        registroRepo.delete(r);
    }

    public List<RegistroDiarioResponseDTO> findByPacienteId(Long pacienteId) {
        return registroRepo.findByPacienteId(pacienteId).stream()
                .map(RegistroDiarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
