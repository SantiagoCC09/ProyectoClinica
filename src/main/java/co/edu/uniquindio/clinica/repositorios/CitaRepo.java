package co.edu.uniquindio.clinica.repositorios;



import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.EstadoCita;
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

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.medico.nombre = :nombreMedico")
    List<Cita>listarCitasPorNombreMedico(int codigoPaciente , String nombreMedico);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.medico.codigo = :codigoMedico")
    List<Cita>listarCitasPorMedico(int codigoPaciente, int codigoMedico );

    Cita findCitaByIdCita(int id);

    @Query ("select c from Cita c where c.fechaCita = :fecha and c.estadoCita = 'Programada' ")
    List <Cita> listarCitaPendientePorFecha(LocalDateTime fecha);

    @Query ("select c from Cita c where c.paciente.nombre = :nombre")
    List<Cita> listarPorNombrePaciente(String nombre);

    @Query ("select c from Cita c where c.paciente.cedula = :cedula")
    List<Cita> listarPorCedulaPaciente(String cedula);
}
