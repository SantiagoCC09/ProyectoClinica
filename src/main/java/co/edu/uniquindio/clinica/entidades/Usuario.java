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
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Usuario extends Cuenta implements Serializable {



@Id
@EqualsAndHashCode.Include
private String cedula;

@Column(nullable = false, length = 100)
private String nombre;
@Column(length = 15)
private String telefono;
@Column
private String urlFoto;
@Column
private Ciudad ciudad;


}
