package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.Ciudad;

import co.edu.uniquindio.clinica.entidades.EstadoUsuario;
import co.edu.uniquindio.clinica.entidades.TipoSangre;

import java.util.Date;


public record PacienteDTO(String cedulaPaciente,

                          String email,

                          String password,

                          String nombreCompleto,

                          String telefono,

                          Ciudad ciudadResidencia,
                          Date fechaNacimiento,

                          String urlFoto,
                          TipoSangre rh
) {


}
