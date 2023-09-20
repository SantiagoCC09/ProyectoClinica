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



<<<<<<< HEAD

    private String cedulaPaciente;

    private String email;


    private String password;


    private String nombreCompleto;


    private Date fechaNacimiento;


    private String telefono;

    private String ciudadResidencia;


    private TipoSangre rh;
=======
public record PacienteDTO( String cedulaPaciente,

        String email,

        String password,

        String nombreCompleto,

        String telefono,

        String ciudadResidencia, Date fechaNacimiento, TipoSangre rh   ) {



>>>>>>> 6f326407af7f81f27c80af285f9c6553188f46f8

}
