package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoCita;

import java.sql.Date;

public record PQRDTO (


        String estado,


        String descripcion,

        Date fecha,

        String nombrePaciente,

        int codigoAdministrador,
        String motivo


) {

}
