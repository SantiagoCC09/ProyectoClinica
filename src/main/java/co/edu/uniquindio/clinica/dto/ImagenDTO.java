package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Normalized;

public record ImagenDTO (
        @NotNull
        int idImagen,
    @NotNull
    String url){

}
