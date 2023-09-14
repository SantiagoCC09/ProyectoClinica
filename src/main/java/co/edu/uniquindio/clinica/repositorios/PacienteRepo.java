package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

    @Query("select p from Paciente p where p.email = ?1")
    Paciente obtener(String email);

    @Query("select p from Paciente p where p.email = :email and p.contrasenia =:contrasenia")
    Paciente comprobarAutenticacion(String email, String contrasenia);

    @Query("select p from Paciente p where p.email = :email")
    Paciente buscarPaciente(String email);


    @Query("select p from Paciente p where p.email = :email")
    Optional<Paciente> findByEmail(String email);


}
