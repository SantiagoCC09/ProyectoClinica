package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception;

    int eliminarMedico(int codigoMedico) throws Exception;

    List<MedicoDTO> listarMedicos();

    MedicoDTO obtenerMedico(int idMedico) throws Exception;

    List<PQRDTO> listarPQRS();

    int responderPQRS(RespuestaDTO respuestaDTO, int idPqr) throws Exception;

    PQRDTO verDetallePQRS(int idPqr) throws Exception;


    void cambiarEstadoPqr (int codigoPqr, EstadoPqr estadoPqr);


}
