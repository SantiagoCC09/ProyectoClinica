package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;

public interface CitaServicio {

     int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception;

    int actualizarCita(CitaDTOAdmin citaDTOAdmin , int codigoCita) throws Exception;

    int eliminarCita(int codigoCita) throws Exception;

    Cita obtenerCita(int codigoCita) throws Exception;



}
