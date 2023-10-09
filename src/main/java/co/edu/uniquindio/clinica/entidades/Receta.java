package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Receta {

    @Id
    @Column
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
