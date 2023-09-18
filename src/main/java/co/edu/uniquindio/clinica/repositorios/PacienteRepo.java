package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente,Integer> {


    @Query("select p from Paciente p where p.email = :email")
     Paciente buscarPacienteEmail(String email);

    @Query("select p from Paciente p where p.codigo = :codigo")
    Paciente buscarPacienteCodigo(int codigo);

    @Query("select p from Paciente p where p.cedula = :cedulaPaciente")
    List<Cita> listarCitasPaciente(String cedulaPaciente);

    /**
     * Envia Correo al paciente
     * @param email
     * @return
     */
    @Query("select p from Paciente p where p.email = :email")
    Optional<Paciente> findByEmail(String email);




}
