package co.edu.uniquindio.clinica.entidades;

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
public class Respuesta implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int idRespuesta;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    private PQR pqr;

    @OneToOne
    private Respuesta respuesta;

    @ManyToOne
    private Cuenta cuenta;


}
