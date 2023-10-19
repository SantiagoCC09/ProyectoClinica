package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record PQRDTOPaciente(

        @NotNull
        EstadoPqr estado,

        @NotNull
        String descripcion,

        @NotNull
        Date fecha,

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
