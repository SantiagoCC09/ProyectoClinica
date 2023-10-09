package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.SesionDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;

public interface AutenticacionServicio {

    TokenDTO login(SesionDTO sesionDTO);
}
