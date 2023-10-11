package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PQRDTOPaciente(

        @NotNull
        EstadoPqr estado,

        @NotNull
        String descripcion,

        @NotNull
        LocalDateTime fecha,

        @NotNull
        LocalDateTime fechaCreacion,

        @NotNull
        int codigoAdministrador,
        @NotNull
        String motivo,
        @NotNull

        int codigoPaciente
) {

}
