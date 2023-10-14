package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;
import java.util.List;

public record RespuestaDTO(

        int id,
        String descripcion,
        LocalDateTime fecha,
        int codigoCuenta,
        int idPQR,

        List<RespuestaDTO> repuestas

) {




}
