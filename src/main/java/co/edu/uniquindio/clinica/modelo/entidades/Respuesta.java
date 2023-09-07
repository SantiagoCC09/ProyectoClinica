package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int idRespuesta;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha;

}
