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
