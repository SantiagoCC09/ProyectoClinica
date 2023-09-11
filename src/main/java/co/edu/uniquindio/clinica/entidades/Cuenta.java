package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @Column(nullable = false,unique = true, length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String password;

}
