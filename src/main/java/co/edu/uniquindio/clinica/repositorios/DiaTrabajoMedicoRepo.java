package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.DiaTrabajoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface DiaTrabajoMedicoRepo extends JpaRepository<DiaTrabajoMedico,Integer> {

    List<DiaTrabajoMedico> findAllByMedicoCodigo(int codigo);


    @Query ("select d from DiaTrabajoMedico d where d.fecha = :fecha")
    DiaTrabajoMedico findDiaTrabajoMedicoByFecha(Date fecha);
}
