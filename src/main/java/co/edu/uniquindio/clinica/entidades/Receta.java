package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Receta {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceta;
    @Column
    private String descripcion;
    @Column
    private String instrucciones;

    @OneToMany (mappedBy = "receta")
    private List <Medicamento> listaMedicamentos;

    @OneToOne
    private Consulta consulta;

}
