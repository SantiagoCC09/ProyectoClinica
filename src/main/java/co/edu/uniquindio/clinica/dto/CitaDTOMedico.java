package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record CitaDTOMedico(

                            int codigoCita,
                            String nombrePaciente,
                            LocalDateTime fechaCreacion, Date fechaCita,
                            String motivo,

                            String cedulaPaciente,

                            int codigoPaciente)

{


}
