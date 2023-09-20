package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record DiaTrabajoMedicoDTO(LocalDateTime fecha, int id, boolean esLibre, int idMedico) {
}
