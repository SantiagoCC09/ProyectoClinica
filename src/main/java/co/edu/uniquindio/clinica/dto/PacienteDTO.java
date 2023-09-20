package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.AlergiaPaciente;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.EPS;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.sql.Date;



public record PacienteDTO( String cedulaPaciente,

        String email,

        String password,

        String nombreCompleto,

        String telefono,

        String ciudadResidencia, Date fechaNacimiento, TipoSangre rh   ) {




}
