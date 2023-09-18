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


@AllArgsConstructor
@Getter
@Setter
public class PacienteDTO {

    @NotBlank
    @NotNull
    private String cedulaPaciente;
    @NotBlank
    @NotNull
    @Length(max = 150, message = "error en la estructura del correo")
    private String email;

    @NotBlank
    @NotNull
    @Length(max = 150, message = "password maximo 100 caracteres")
    private String contrasenia;

    @NotBlank
    @NotNull
    @Length(max=200, message = "nombre completo maximo 200 caracteres")
    private String nombreCompleto;

    @NotBlank
    @NotNull
    private Date fechaNacimiento;

    @NotBlank
    @NotNull
    @Length(max=150, message = "numero de telefono maximo 12 caracteres")
    private String telefono;
    @NotBlank
    @NotNull
    @Length(max=150, message = "ciudad de residencia maximo 150 caracteres")
    private String ciudadResidencia;

}
