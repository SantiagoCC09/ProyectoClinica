package co.edu.uniquindio.clinica.dto;

<<<<<<< HEAD
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
=======
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
>>>>>>> 76631c8fb4b9fefefb3b95ac0b522ddb8905506e

import java.util.List;

public record MedicoDTO(
<<<<<<< HEAD
=======
        @NotNull @Length(max = 100) String nombre,
        @NotNull @Length(max = 11) String cedula,
        @NotNull @Length(max = 50) Ciudad ciudad, @NotNull String URL_foto,
        Especialidad especialidad,
        @Length(max = 15) String telefono,
        @NotNull @Length(max = 100) String correo,
        @NotNull @Length(max = 100)  String password

>>>>>>> 76631c8fb4b9fefefb3b95ac0b522ddb8905506e

        @NotNull
        String nombre,

        @NotNull
        String cedula,

        @NotNull @Min(0) @Max(3)
        int codigoCiudad,

        @NotNull
        String URL_foto,

        @NotNull
        int codigoEspecialidad,

        @NotNull
        String telefono,

        @NotNull
        String correo,

        @NotNull
        String password,
        List<DiaTrabajoMedicoDTO> horarios

) {
}
