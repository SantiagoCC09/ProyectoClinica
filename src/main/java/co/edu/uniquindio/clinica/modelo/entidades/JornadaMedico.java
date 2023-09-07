package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class JornadaMedico implements Serializable {

    private Time horaInicio;

    private Time horaFinal;

    @Id
    private int idJornadaMedico;

    @ManyToOne
    private diaTrabajoMedico idDiaTrabajo;
}
