package com.globalsolution.repository;

import com.globalsolution.entity.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
    List<RegistroDiario> findByPacienteId(Long pacienteId);
}

