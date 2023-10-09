package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoDia;

import java.time.LocalDateTime;

public record DiaTrabajoMedicoDTO(
        LocalDateTime fecha,
        int id,
        EstadoDia estadoDia,
        int idMedico) {
}
