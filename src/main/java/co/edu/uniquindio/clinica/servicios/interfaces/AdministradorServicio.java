package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.Medico;
import co.edu.uniquindio.clinica.entidades.PQR;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception;

    int eliminarMedico(int codigoMedico) throws Exception;

    List <Medico> listarMedicos();

    Medico obtenerMedico(int idMedico);

    List<PQR> listarPQRS();

    int responderPQRS(RespuestaDTO respuestaDTO, int idPqr);

    String verDetallePQRS(int idPqr);



}
