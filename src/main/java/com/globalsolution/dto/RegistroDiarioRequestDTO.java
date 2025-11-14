package com.globalsolution.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RegistroDiarioRequestDTO {

    @NotNull(message = "dataRegistro é obrigatória")
    private LocalDateTime dataRegistro;

    @NotNull
    @Min(1) @Max(5)
    private Integer nivelHumor;

    @NotNull
    @Min(1) @Max(5)
    private Integer nivelAnsiedade;

    private Double horasSono;

    @NotNull(message = "pacienteId é obrigatório")
    private Long pacienteId;

    // getters / setters
    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }

    public Integer getNivelHumor() { return nivelHumor; }
    public void setNivelHumor(Integer nivelHumor) { this.nivelHumor = nivelHumor; }

    public Integer getNivelAnsiedade() { return nivelAnsiedade; }
    public void setNivelAnsiedade(Integer nivelAnsiedade) { this.nivelAnsiedade = nivelAnsiedade; }

    public Double getHorasSono() { return horasSono; }
    public void setHorasSono(Double horasSono) { this.horasSono = horasSono; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
}
