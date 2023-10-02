package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record CitaDTOAdmin(

    int codigoCita,
    String nombrePaciente,
    String nombreMedico,
    LocalDateTime fechaCreacion, LocalDateTime fechaCita,
    String motivo,

    String cedulaPaciente,

   String cedulaMedico

) {

}
