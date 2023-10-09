package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoCita;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDateTime;

public record PQRDTO (



         EstadoPqr estado,

        String descripcion,

        LocalDateTime fecha,

        String nombre,

        int codigoAdmin,

        String motivo
) {

}
