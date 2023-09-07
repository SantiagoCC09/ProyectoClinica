package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int idCita;

    @ManyToOne
    @JoinColumn(name = "pacienteCedula") // Nombre de la columna que contendrá la llave foránea
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoCedula") // Nombre de la columna que contendrá la llave foránea
    private Medico medico;
}

