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

    @Column(nullable = true, length = 255)
    private String tratamiento;

    @Column(nullable = false, length = 500)
    private String notasMedicas;

    @Column(nullable = false, length = 100)
    private String detalleConsulta;

    @OneToOne
    private Cita cita;


}
