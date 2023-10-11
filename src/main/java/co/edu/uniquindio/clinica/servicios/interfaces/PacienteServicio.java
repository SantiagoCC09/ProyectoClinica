package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.PQR;
import co.edu.uniquindio.clinica.entidades.Paciente;

import java.sql.Date;
import java.util.List;

public interface PacienteServicio {

    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarPerfil(PacienteDTO pacienteDTO, int codigoPaciente) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    Paciente obtenerPaciente(int codigoPaciente) throws Exception;

    void enviarLinkRecuperacion();



//El paciente podrá crear PQR
    public int crearPqr(PQRDTOPaciente pqrDto) throws Exception;
    public void actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception;
    public void eliminarPqr(int idPqr) throws Exception;
    public PQR obtenerPqr(int idPqr) throws Exception;

    List<InfoPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    void responderPQRS();

    void verDetalleCita();

     void validarExiste(int cedulaPaciente) throws Exception;


    public void filtrarHistorialPorFecha();

    public void filtrarHistorilaPorId ();



}

