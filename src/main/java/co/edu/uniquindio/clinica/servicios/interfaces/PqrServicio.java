package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.PQRDTOPaciente;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.PQR;

import java.util.List;

public interface PqrServicio {



   int responderPqr (RespuestaDTO respuestaDto);

   public int crearPqr(PQRDTOPaciente pqrDto) throws Exception;
   public int actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception;
   public int eliminarPqr(int idPqr) throws Exception;
   public PQR obtenerPqr(int idPqr) throws Exception;
    
}
