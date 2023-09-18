package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Administrador extends Cuenta implements Serializable {
    @OneToMany (mappedBy = "administrador")
    private List<PQR> pqrs;


}
