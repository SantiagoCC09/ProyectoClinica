package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

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

    @OneToOne
    private Respuesta idRespuesta;

    @Column(nullable = false, length = 15)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    private Paciente cedulaPaciente;

    @ManyToOne
    private Administrador administrador;


}
