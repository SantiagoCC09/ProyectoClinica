package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PasswordDTO(

        @NotNull(message = "La contraseña no puede ser nulo")
        @NotBlank(message = "La contraseña no puede ser vacio")
         String password,

        @NotNull(message = "La contraseña no puede ser nulo")
        @NotBlank(message = "La contraseña no puede ser vacio")
         String passwordRepeated

) {
}
