package co.edu.uniquindio.clinica.dto;

import org.springframework.http.HttpStatus;

public record MensajeDTO<T>(

        HttpStatus estado,
        boolean error,
         T respuesta

) {
}
