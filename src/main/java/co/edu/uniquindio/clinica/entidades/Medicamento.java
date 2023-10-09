package co.edu.uniquindio.clinica.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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

}
