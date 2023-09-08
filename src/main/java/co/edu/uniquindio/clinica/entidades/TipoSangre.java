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
public class TipoSangre implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int idTipoSangre;

    @Column(nullable = false, length = 15)
     private String tipo;
    @Column(nullable = false, length = 2)
     private String rh;
     @OneToMany(mappedBy = "rh")
     private List<Paciente> pacientes;
}
