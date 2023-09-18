package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false, length = 40)
    private String ciudadResidencia;
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @Column(nullable = false)
    private Especialidad especialidad;

}
