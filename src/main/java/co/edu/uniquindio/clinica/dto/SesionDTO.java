package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SesionDTO(

        String email,


         String password,

        int tipo


) {
}
