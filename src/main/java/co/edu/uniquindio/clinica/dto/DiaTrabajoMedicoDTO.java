package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoDia;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DiaTrabajoMedicoDTO(

        @NotNull
        LocalDateTime fecha,
        @NotNull
        int id,
        @NotNull
        EstadoDia estadoDia,
        @NotNull
        int idMedico) {
}
