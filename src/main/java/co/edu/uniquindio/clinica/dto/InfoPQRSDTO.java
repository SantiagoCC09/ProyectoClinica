package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.EstadoPqr;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO (

        int codigo,
        EstadoPqr estado,
        String motivo,
        String nombrePaciente,
        LocalDateTime fecha,
        List<String> mensajes

) {
}

