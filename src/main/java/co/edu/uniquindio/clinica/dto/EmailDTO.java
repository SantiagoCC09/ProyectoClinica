package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public record EmailDTO (String para, String asunto, String mensaje){

}



