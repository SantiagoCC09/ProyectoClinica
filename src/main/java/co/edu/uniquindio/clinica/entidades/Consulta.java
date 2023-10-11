package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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


    @Column(nullable = false, length = 500)
    private String notasMedicas;

    private String tratamiento;

    private String detallesConsulta;

    @OneToOne
    private Cita cita;

    @OneToOne (mappedBy = "consulta")
    private Receta receta;
}
