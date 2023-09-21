package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.NuevaPasswordDTO;

public interface ReestablecerPasswordServicio {

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDto) throws Exception;


}
