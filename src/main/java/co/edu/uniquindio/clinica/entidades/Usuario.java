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
<<<<<<< HEAD
=======
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
>>>>>>> 39cd575613b41066f6e51dd93de0b1ffee0d3fcc

public class Usuario extends Cuenta implements Serializable {


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false)
    private String urlFoto;

    @Column(nullable = false, length = 50)
    private Ciudad ciudad;

    @Column(nullable = false, length = 20)
    private String cedula;
}
