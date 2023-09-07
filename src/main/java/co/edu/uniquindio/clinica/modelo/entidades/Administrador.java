package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
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

    private String email;
    private String contrasenia;
    @OneToMany (mappedBy = "administrador")
    private List<PQR> pqrs;


}
