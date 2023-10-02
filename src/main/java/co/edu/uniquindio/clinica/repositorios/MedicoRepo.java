package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico,Integer> {


    boolean findByCorreo(String correo);


    //si usamos findBy no hay que usar el query
    boolean findByCedula(String cedula);
}
