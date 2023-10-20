package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoDia;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DiaTrabajoMedicoDTO(

        @NotNull
        Date fecha,
        @NotNull
        int id,
        @NotNull
        EstadoDia estadoDia,
        @NotNull
        int idMedico) {
}
