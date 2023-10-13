package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.InfoPQRSDTO;
import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.PQRDTOPaciente;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.PQR;

import java.util.List;

public interface PqrServicio {

   public int crearPqr(PQRDTOPaciente pqrDto) throws Exception;

   public void actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception;

   public void eliminarPqr(int idPqr) throws Exception;

   public PQR obtenerPqr(int idPqr) throws Exception;

   List<PQRDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;



   public int crearPqr(PQRDTOPaciente pqrDto) throws Exception;
   public int actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception;
   public int eliminarPqr(int idPqr) throws Exception;
   public PQR obtenerPqr(int idPqr) throws Exception;
    
}
