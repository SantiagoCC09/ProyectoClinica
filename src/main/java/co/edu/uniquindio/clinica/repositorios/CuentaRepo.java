package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepo extends JpaRepository <Cuenta, Integer> {

    Optional<Cuenta> findByEmail(String email);



}
