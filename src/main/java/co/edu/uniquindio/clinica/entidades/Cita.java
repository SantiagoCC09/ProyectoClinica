package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    //  @JoinColumn(name = "pacienteCedula") // Nombre de la columna que contendrá la llave foránea
    private Paciente paciente;

    @ManyToOne
    // @JoinColumn(name = "medicoCedula") // Nombre de la columna que contendrá la llave foránea
    private Medico medico;

    @Column(nullable = false, length = 200)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private Date fechaCita;
    @OneToOne (mappedBy = "cita")
    private Consulta consulta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estadoCita;
}

