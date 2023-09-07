package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private int idConsulta;

    private LocalDateTime fechaCreacion;

    private String motivoConsulta;

    @ManyToOne
    private Paciente cedulaPaciente;

    @ManyToOne
    private Medico cedulaMedico;

    private String detalleConsulta;

    private Estado estado;

    private Date fechaAsistencia;

    private Time horaCita;



}
