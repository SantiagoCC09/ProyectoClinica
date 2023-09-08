package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String contrasenia;
    @OneToMany (mappedBy = "administrador")
    private List<PQR> pqrs;


}
