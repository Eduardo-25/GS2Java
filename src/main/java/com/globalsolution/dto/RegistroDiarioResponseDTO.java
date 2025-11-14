package com.globalsolution.dto;

import java.time.LocalDateTime;

public class RegistroDiarioResponseDTO {
    private Long id;
    private LocalDateTime dataRegistro;
    private Integer nivelHumor;
    private Integer nivelAnsiedade;
    private Double horasSono;
    private Long pacienteId;
    private String pacienteNome;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getPacienteNome() { return pacienteNome; }
    public void setPacienteNome(String pacienteNome) { this.pacienteNome = pacienteNome; }
}
