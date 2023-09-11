package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Medico extends Usuario implements Serializable {




    @Column(nullable = false, length = 40)
    private String ciudadResidencia;
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    private Especialidad especialidad;

}
