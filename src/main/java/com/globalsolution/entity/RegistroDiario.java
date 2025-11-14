package com.globalsolution.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registros_diarios")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "nivel_humor", nullable = false)
    private Integer nivelHumor;   // 1..5

    @Column(name = "nivel_ansiedade", nullable = false)
    private Integer nivelAnsiedade; // 1..5

    @Column(name = "horas_sono")
    private Double horasSono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // getters e setters
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

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
