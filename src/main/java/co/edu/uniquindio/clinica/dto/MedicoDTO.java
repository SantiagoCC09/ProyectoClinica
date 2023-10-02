package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record MedicoDTO(
        @NotNull @Length(max = 100) String nombre,
        @NotNull @Length(max = 11) String cedula,
        @NotNull @Length(max = 50) Ciudad ciudad, @NotNull String URL_foto,
        Especialidad especialidad,
        @Length(max = 15) String telefono,
        @NotNull @Length(max = 100) String correo,
        @NotNull @Length(max = 100)  String password


){
}
