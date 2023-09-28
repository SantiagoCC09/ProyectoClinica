package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico,Integer> {

    @Query("select m from Medico m where m.email = :correo")
    boolean buscarEstaCorreo(String correo);

    @Query("select m from Medico m where m.cedula = :cedula")
    boolean buscarEstaCedula(String cedula);
}
