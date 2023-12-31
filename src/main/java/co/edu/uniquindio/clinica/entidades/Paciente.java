package co.edu.uniquindio.clinica.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Paciente extends Usuario implements Serializable {

    @Column(nullable = false)
    private EPS eps;

    @Column(nullable = false)
    private TipoSangre rh;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private List<PQR> listaPqrs;

    @Column(nullable = false)
    private String alergias;

}
