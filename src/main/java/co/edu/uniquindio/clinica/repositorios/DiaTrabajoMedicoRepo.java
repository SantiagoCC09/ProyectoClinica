package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.DiaTrabajoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaTrabajoMedicoRepo extends JpaRepository<DiaTrabajoMedico,Integer> {
}
