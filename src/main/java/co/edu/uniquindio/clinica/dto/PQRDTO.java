package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoCita;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;

import java.sql.Date;

public record PQRDTO (


        EstadoPqr estado,


        String descripcion,

        Date fecha,

        String nombrePaciente,

        int codigoAdministrador,
        String motivo


) {

}
