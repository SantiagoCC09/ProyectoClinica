package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepo extends JpaRepository<Integer, Paciente> {




    /**
     * Envia Correo al paciente
     * @param email
     * @return
     */
    @Query("select p from Paciente p where p.email = :email")
    Optional<Paciente> findByEmail(String email);




}
