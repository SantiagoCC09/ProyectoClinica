package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Administrador;
import co.edu.uniquindio.clinica.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository <Administrador, Integer> {


    @Query("select a from Administrador a where a.email = :email")
    Optional<Administrador> findByEmail(String email);



}
