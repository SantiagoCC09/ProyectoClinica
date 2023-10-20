package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record InfoCitaDTO (

        @NotNull
        int codigoCita,
        @NotNull
        String nombrePaciente,
        @NotNull
        String nombreMedico,
        @NotNull
        Date fecha,
        @NotNull
        String motivo){




}
