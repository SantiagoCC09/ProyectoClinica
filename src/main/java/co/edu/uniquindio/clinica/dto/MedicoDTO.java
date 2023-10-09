package co.edu.uniquindio.clinica.dto;


import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record MedicoDTO(

        @NotNull
        String nombre,

        @NotNull
        String cedula,

        @NotNull @Min(0) @Max(3)
        Ciudad ciudad,

        @NotNull
        String URL_foto,

        @NotNull
        Especialidad especialidad,

        @NotNull
        String telefono,

        @NotNull
        String correo,

        @NotNull
        String password,
        List<DiaTrabajoMedicoDTO> horarios

) {
}
