package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoCita;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDateTime;

public record PQRDTO (

        @NotNull
         EstadoPqr estado,

        @NotNull
        String descripcion,

        @NotNull
        LocalDateTime fecha,

        @NotNull
        String nombre,

        @NotNull
        int codigoAdmin,

        @NotNull
        String motivo
) {

}
