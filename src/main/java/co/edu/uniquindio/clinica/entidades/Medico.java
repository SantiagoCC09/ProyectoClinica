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

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @Column(nullable = false)
    private Especialidad especialidad;

    @OneToMany (mappedBy = "medico")

    private List<DiaTrabajoMedico> diasTrabajo;


}
