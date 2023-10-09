package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Administrador;
import co.edu.uniquindio.clinica.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepo extends JpaRepository<Medico,Integer> {


    Medico findByEmail(String email);

    Medico findByCedula(String cedula);
}
