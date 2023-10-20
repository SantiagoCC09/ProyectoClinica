package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiaTrabajoMedico implements Serializable {

    @Column(nullable = false)
    private Date fecha;

    @Id
    private int idDiaTrabajo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoDia estadoDia;

    @ManyToOne
    @JoinColumn(name = "codigoMedico") // Nombre de la columna que contendrá la llave foránea
    private Medico medico;

    @OneToMany (mappedBy = "diaTrabajo")
    List<JornadaMedico> listaJornadasMedico;









}
