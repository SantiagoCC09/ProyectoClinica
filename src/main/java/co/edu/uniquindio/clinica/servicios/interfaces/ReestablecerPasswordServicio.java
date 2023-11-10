package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.NuevaPasswordDTO;
import co.edu.uniquindio.clinica.dto.PasswordDTO;

public interface ReestablecerPasswordServicio {

    int cambiarConstrasenaAnterior(int idPerson, PasswordDTO passwordDTO) throws Exception;

    void recuperarContrasena(String email) throws Exception;

    String cambiarContrasenaRecuperada(String email, PasswordDTO passwordDTO) throws Exception;


}
