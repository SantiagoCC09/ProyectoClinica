package co.edu.uniquindio.clinica.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Medicamento {


    @Id
    @Column
    private int idMedicamento;

    @Column
    private String efectosSecundarios;

    @Column
    private String nombre;

    @ManyToOne
    private Receta receta;

    @ManyToOne
    private Administrador administrador;


    @Enumerated(EnumType.STRING)
    @Column
    private EstadoMedicamento estadoMedicamento;

}
