package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQR implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPqr;

    private EstadoPqr estado;

    @OneToMany ( mappedBy = "pqr")
    private List<Respuesta> respuestas;

    @Column(nullable = false, length = 15)
    private String descripcion;

    @Column
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Administrador administrador;



}
