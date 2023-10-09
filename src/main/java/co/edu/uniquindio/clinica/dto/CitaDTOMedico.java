package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record CitaDTOMedico(

                            int codigoCita,
                            String nombrePaciente,
                            LocalDateTime fechaCreacion, LocalDateTime fechaCita,
                            String motivo,

                            String cedulaPaciente,

                            int codigoPaciente)

{


}
