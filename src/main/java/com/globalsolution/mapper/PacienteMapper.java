package com.globalsolution.mapper;

import com.globalsolution.dto.PacienteRequestDTO;
import com.globalsolution.dto.PacienteResponseDTO;
import com.globalsolution.entity.Paciente;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO dto) {
        Paciente p = new Paciente();
        p.setNome(dto.getNome());
        p.setEmail(dto.getEmail());
        p.setDataNascimento(dto.getDataNascimento());
        return p;
    }

    public static PacienteResponseDTO toDTO(Paciente p) {
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setEmail(p.getEmail());
        dto.setDataNascimento(p.getDataNascimento());
        return dto;
    }

    public static void updateEntityFromDTO(PacienteRequestDTO dto, Paciente p) {
        p.setNome(dto.getNome());
        p.setEmail(dto.getEmail());
        p.setDataNascimento(dto.getDataNascimento());
    }
}

