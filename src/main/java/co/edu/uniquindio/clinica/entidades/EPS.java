package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EPS implements Serializable {
   @Id
   @EqualsAndHashCode.Include
    private int idEPS;

    @Column(nullable = false, length = 100)
   private String nombre;

    @OneToMany(mappedBy = "eps")
    @Column(nullable = false)
    private List<Paciente> pacientes;

}
