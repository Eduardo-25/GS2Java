package com.globalsolution;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.globalsolution.entity.Paciente;
import com.globalsolution.entity.RegistroDiario;
import com.globalsolution.repository.PacienteRepository;
import com.globalsolution.repository.RegistroDiarioRepository;

@SpringBootApplication
public class GlobalSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalSolutionApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PacienteRepository pacienteRepo, RegistroDiarioRepository registroRepo) {
        return args -> {
            if (pacienteRepo.count() == 0) {
                Paciente p1 = new Paciente();
                p1.setNome("Lucas Andrade");
                p1.setEmail("lucas.andrade@example.com");
                p1.setDataNascimento(LocalDate.of(1997, 5, 12));
                pacienteRepo.save(p1);

                Paciente p2 = new Paciente();
                p2.setNome("Ana Carvalho");
                p2.setEmail("ana.carvalho@example.com");
                p2.setDataNascimento(LocalDate.of(1984, 2, 3));
                pacienteRepo.save(p2);

                RegistroDiario r1 = new RegistroDiario();
                r1.setPaciente(p1);
                r1.setDataRegistro(LocalDateTime.now().minusDays(1));
                r1.setNivelHumor(3);
                r1.setNivelAnsiedade(2);
                r1.setHorasSono(7.5);
                registroRepo.save(r1);

                RegistroDiario r2 = new RegistroDiario();
                r2.setPaciente(p2);
                r2.setDataRegistro(LocalDateTime.now());
                r2.setNivelHumor(2);
                r2.setNivelAnsiedade(4);
                r2.setHorasSono(5.0);
                registroRepo.save(r2);
            }
        };
    }
}

