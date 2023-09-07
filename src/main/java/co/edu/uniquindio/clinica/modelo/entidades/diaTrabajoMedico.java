package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class diaTrabajoMedico implements Serializable {

    private LocalDateTime fecha;

    @Id
    private int idDiaTrabajo;

    private boolean eslibre;

    @ManyToOne
    @JoinColumn(name = "cedulaMedico") // Nombre de la columna que contendrá la llave foránea
    private Medico cedulaMedico;





}
