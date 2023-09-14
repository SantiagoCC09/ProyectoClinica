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
=======
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
>>>>>>> 78a94fc0915872cb17a36fd45902461b806e39bf

public class Usuario extends Cuenta implements Serializable {

@Column(nullable = false, length = 100)
private String nombre;
@Column(length = 15)
private String telefono;
@Column
private String urlFoto;
@Column
private Ciudad ciudad;


}
