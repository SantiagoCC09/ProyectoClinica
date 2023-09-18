package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.CitaGetDTO;
import co.edu.uniquindio.clinica.dto.PQRGetDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;

import java.util.List;

public interface PacienteServicio {

    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarPerfil(PacienteDTO pacienteDTO, int codigoPaciente) throws Exception;

    int eliminarCuenta(int codigoPaciente) throws Exception;

    void enviarLinkRecuperacion();

    void cambiarPassword();

    void agendarCita();

    void crearPQRS();

    List<PQRGetDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    void responderPQRS();

    List <CitaGetDTO> listarCitasPaciente(String cedulaPaciente) throws Exception;

    void filtrarCitasPorFecha();

    void filtrarCitasPorMedico();

    void verDetalleCita();

     void validarExiste(int cedulaPaciente) throws Exception;


    public void filtrarHistorialPorFecha();

    public void filtrarHistorilaPorId ();



}

