package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoPqr;

import java.time.LocalDateTime;

public record PQRDTOPaciente(
        EstadoPqr estado,

        String descripcion,

        LocalDateTime fecha,

        LocalDateTime fechaCreacion,
        int codigoAdministrador,

        String motivo,

        int codigoPaciente
) {

}
