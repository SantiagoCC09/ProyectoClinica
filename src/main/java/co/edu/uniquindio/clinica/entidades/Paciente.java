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

public class Paciente extends Usuario implements Serializable {


    private EPS eps;

    private TipoSangre rh;
    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false, length = 40)
    private String ciudadResidencia;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<PQR> listaPqrs;

    @OneToMany
    private List <AlergiaPaciente> alergiasPaciente;


}
