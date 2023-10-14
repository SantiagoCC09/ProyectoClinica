package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.PQR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PQRSRepo extends JpaRepository<PQR, Integer> {

    @Query("select pq from PQR pq where pq.paciente = :codigoPaciente")
    List<PQR>listarPQRSPorPaciente(int codigoPaciente);

    PQR findPQRByIdPqr(int idPqr);




}
