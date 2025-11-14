package com.globalsolution.mapper;

import com.globalsolution.dto.RegistroDiarioRequestDTO;
import com.globalsolution.dto.RegistroDiarioResponseDTO;
import com.globalsolution.entity.Paciente;
import com.globalsolution.entity.RegistroDiario;

public class RegistroDiarioMapper {

    public static RegistroDiario toEntity(RegistroDiarioRequestDTO dto, Paciente paciente) {
        RegistroDiario r = new RegistroDiario();
        r.setDataRegistro(dto.getDataRegistro());
        r.setNivelHumor(dto.getNivelHumor());
        r.setNivelAnsiedade(dto.getNivelAnsiedade());
        r.setHorasSono(dto.getHorasSono());
        r.setPaciente(paciente);
        return r;
    }

    public static RegistroDiarioResponseDTO toDTO(RegistroDiario r) {
        RegistroDiarioResponseDTO dto = new RegistroDiarioResponseDTO();
        dto.setId(r.getId());
        dto.setDataRegistro(r.getDataRegistro());
        dto.setNivelHumor(r.getNivelHumor());
        dto.setNivelAnsiedade(r.getNivelAnsiedade());
        dto.setHorasSono(r.getHorasSono());
        if (r.getPaciente() != null) {
            dto.setPacienteId(r.getPaciente().getId());
            dto.setPacienteNome(r.getPaciente().getNome());
        }
        return dto;
    }

    public static void updateEntityFromDTO(RegistroDiarioRequestDTO dto, RegistroDiario r) {
        r.setDataRegistro(dto.getDataRegistro());
        r.setNivelHumor(dto.getNivelHumor());
        r.setNivelAnsiedade(dto.getNivelAnsiedade());
        r.setHorasSono(dto.getHorasSono());
        // paciente tratado no service
    }
}
