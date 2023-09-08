package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailDTO {

    @NotBlank
    @NotNull
    private String asunto;
    @NotBlank
    @NotNull
    private String cuerpo;
    @NotBlank
    @NotNull
    private String destinatario;


}
