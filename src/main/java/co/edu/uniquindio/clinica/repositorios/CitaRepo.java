package co.edu.uniquindio.clinica.repositorios;



import co.edu.uniquindio.clinica.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository < Cita, Integer > {


    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente")
    List<Cita> listarCitasPaciente(int codigoPaciente);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.fechaCita = :fecha")
    List<Cita> listarCitasPorFecha(int codigoPaciente, Date fecha);

    @Query("select c from Cita c where c.medico.nombre = :nombreMedico")
    List<Cita>listarCitasPorNombreMedico(String nombreMedico);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.medico.codigo = :codigoMedico")
    List<Cita>listarCitasPorMedico(int codigoPaciente, int codigoMedico );

    Cita findCitaByIdCita(int id);

}
