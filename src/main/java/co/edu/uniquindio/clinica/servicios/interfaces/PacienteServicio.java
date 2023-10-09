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



//EL paciente podrá crear las citas y demás

    int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception;

    int actualizarCita(CitaDTOAdmin citaDTOAdmin , int codigoCita) throws Exception;

    int eliminarCita(int codigoCita) throws Exception;

    Cita obtenerCita(int codigoCita) throws Exception;


    List <InfoCitaDTO> listarCitasPaciente(String cedulaPaciente) throws Exception;

    //El paciente podrá filtrar las citas por fecha
    List<InfoCitaDTO> filtrarCitasPorFecha(Date fecha, String cedulaPaciente) throws Exception;

    List<InfoCitaDTO> filtrarCitasPorMedico(int codigoMedico)throws Exception;

    void verDetalleCita();

     void validarExiste(int cedulaPaciente) throws Exception;


    public void filtrarHistorialPorFecha();

    public void filtrarHistorilaPorId ();



}

