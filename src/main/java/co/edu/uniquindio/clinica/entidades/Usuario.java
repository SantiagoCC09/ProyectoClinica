package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class Usuario extends Cuenta implements Serializable {


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false)
    private String urlFoto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Ciudad ciudad;

    @Column(nullable = false, length = 11)
    private String cedula;

    @Enumerated(EnumType.STRING)
    @Column
    private EstadoUsuario estado;
}
