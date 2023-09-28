package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alergia implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int idAlergia;

    @Column(nullable = false, length = 100)
    private String nombre;


}
