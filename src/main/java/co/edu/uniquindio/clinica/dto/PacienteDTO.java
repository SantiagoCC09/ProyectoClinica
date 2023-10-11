package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.Ciudad;

import co.edu.uniquindio.clinica.entidades.EPS;
import co.edu.uniquindio.clinica.entidades.EstadoUsuario;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record PacienteDTO(

                           @NotNull
                          String cedulaPaciente,

                          @NotNull
                          String email,

                          @NotNull
                          String password,

                          @NotNull
                          String nombreCompleto,

                          @NotNull
                          String telefono,

                          @NotNull
                          @Min(0) @Max(3)
                          Ciudad ciudadResidencia,

                          @NotNull
                          Date fechaNacimiento,

                          @NotNull
                          TipoSangre rh,
                           @NotNull
                           EPS eps,
                           @NotNull
                           String URL_Foto
) {


}
