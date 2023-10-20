package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CitaServicio {

    int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception;

    Cita obtenerCita(int codigoCita) throws Exception;

    int actualizarCita(CitaDTOAdmin citaDTOAdmin , int codigoCita) throws Exception;

    void eliminarCita(int codigoCita) throws Exception;

    List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    //El paciente podrá filtrar las citas por fecha
    List<InfoCitaDTO> filtrarCitasPorFecha(int codigoPaciente, LocalDateTime fecha) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorMedico(int codigoPaciente, int codigoMedico)throws Exception;







}
