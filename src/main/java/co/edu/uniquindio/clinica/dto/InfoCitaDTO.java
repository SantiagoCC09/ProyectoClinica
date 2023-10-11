package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record InfoCitaDTO (

        int codigoCita,
        String nombrePaciente,
        String nombreMedico,

        LocalDateTime fecha,
        String motivo){




}
