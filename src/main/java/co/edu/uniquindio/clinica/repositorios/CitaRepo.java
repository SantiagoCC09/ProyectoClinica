package co.edu.uniquindio.clinica.repositorios;


import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository <Cita, Integer> {



    @Query("select c from Cita c where c.fechaCita = :fecha")
    List<Cita> listarCitasPorFecha(LocalDateTime fecha);

    @Query("select c from Cita c where c.medico.nombre = :nombreMedico")
    List<Cita>listarCitasPorMedico(String nombreMedico);



}
