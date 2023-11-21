package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CuentaRepo extends JpaRepository <Cuenta, Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.email = :email")
    Cuenta findByEmail(@Param("email") String email);




}
