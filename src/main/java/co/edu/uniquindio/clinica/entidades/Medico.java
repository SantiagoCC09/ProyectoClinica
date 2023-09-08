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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medico implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int cedulaMedico;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String contrasenia;

    @Column(nullable = false, length = 100)
    private String nombreCompleto;
    @Column(length = 15)
    private String telefono;
    @Column(nullable = false, length = 40)
    private String ciudadResidencia;
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

}
