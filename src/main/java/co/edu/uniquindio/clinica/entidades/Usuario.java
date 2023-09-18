package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@NoArgsConstructor
<<<<<<< HEAD
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
=======

@AllArgsConstructor
@ToString(callSuper = true)

>>>>>>> bea0c871c4f5738913eafd90a5c668af193d95cc



public class Usuario extends Cuenta implements Serializable {

@Column(nullable = false, length = 100)
private String nombre;
@Column(length = 15)
private String telefono;
@Column
private String urlFoto;
@Column
private Ciudad ciudad;
@Column
private String cedula;
}
