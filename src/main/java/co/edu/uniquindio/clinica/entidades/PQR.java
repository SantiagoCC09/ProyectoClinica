package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
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

    private int estado;

    @OneToMany ( mappedBy = "pqr")
    private List<Respuesta> respuestas;

    @Column(nullable = false, length = 15)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Administrador administrador;


}
