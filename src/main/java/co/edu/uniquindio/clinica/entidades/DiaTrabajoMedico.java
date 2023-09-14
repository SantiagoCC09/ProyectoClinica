package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiaTrabajoMedico implements Serializable {

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Id
    private int idDiaTrabajo;

    @Column(nullable = false)
    private boolean eslibre;

    @ManyToOne
    @JoinColumn(name = "cedulaMedico") // Nombre de la columna que contendrá la llave foránea
    private Medico cedulaMedico;





}
