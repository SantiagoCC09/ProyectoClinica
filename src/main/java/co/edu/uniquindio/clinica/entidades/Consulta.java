package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consulta implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 200)
    private String motivoConsulta;

    @ManyToOne
    private Paciente cedulaPaciente;

    @ManyToOne
    private Medico cedulaMedico;

    @Column(nullable = false, length = 100)
    private String detalleConsulta;
    @Column(nullable = false)
    private Estado estado;
    @Column(nullable = false)
    private Date fechaAsistencia;

    @Column(nullable = false)
    private Time horaCita;



}
