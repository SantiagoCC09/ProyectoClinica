package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoCita;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record CitaDTOAdmin(
        @NotNull
        int codigoCita,
        String nombrePaciente,
        String nombreMedico,


        LocalDateTime fechaCreacion,

        @NotNull
        Date fechaCita,

        @NotNull
        String motivo,

        String cedulaPaciente,

        String cedulaMedico,

        @NotNull
        int codigoPaciente,

        @NotNull
        int codigoMedico,

        EstadoCita estadoCita

) {

}
