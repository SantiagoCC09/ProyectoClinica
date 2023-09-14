package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
