package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.Estado;
import co.edu.uniquindio.clinica.entidades.Respuesta;

import java.sql.Date;

public record PQRDTO (


        Estado estado,

        Respuesta respuesta,

        int idRespuesta,

        String descripcion,

        Date fecha,

        int codigoPaciente,

        int codigoAdministrador


) {

}
