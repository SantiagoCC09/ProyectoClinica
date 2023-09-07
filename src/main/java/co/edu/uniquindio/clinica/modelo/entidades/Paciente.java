package co.edu.uniquindio.clinica.modelo.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Paciente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int cedulaPaciente;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String contrasenia;
    @ManyToOne
    @JoinColumn(name = "eps") // Nombre de la columna que contendrá la llave foránea
    private EPS eps;
    @ManyToOne
    @JoinColumn(name = "rh") // Nombre de la columna que contendrá la llave foránea
    private TipoSangre rh;
    @Column(nullable = false, length = 100)
    private String nombreCompleto;
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(length = 15)
    private String telefono;
    @Column(nullable = false, length = 40)
    private String ciudadResidencia;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "cedulaPaciente")
    private List <AlergiaPaciente> alergiasPaciente;

    
}
