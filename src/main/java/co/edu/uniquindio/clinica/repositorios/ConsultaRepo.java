package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Consulta;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ConsultaRepo extends JpaRepository <Consulta, Integer> {

@Query ("select c from Consulta c where c.cita.fechaCita = :fecha")
    List<Consulta> findConsultaByFecha(Date fecha);

@Query ("select c from Consulta c where c.cita.paciente.cedula = :cedula")
    List<Consulta> findByPacienteId(String cedula);
}
