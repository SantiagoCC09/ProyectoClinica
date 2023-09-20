package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

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
    private Date fecha;
    @OneToOne(mappedBy = "idRespuesta")
    private PQR pqr;

}
