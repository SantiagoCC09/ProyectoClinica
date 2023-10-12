package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record InfoCitaDTO (

        @NotNull
        int codigoCita,
        @NotNull
        String nombrePaciente,
        @NotNull
        String nombreMedico,
        @NotNull
        LocalDateTime fecha,
        @NotNull
        String motivo){




}
