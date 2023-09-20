package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;

public interface CitaServicio {

     int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception;

    int actualizarCita() throws Exception;

    int eliminarCita() throws Exception;

    InfoCitaDTO obtenerCita() throws Exception;



}
