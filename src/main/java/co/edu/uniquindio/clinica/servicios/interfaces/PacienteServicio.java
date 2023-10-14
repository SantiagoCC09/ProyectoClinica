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


    void verDetalleCita();

     void validarExiste(int cedulaPaciente) throws Exception;


    public void filtrarHistorialPorFecha();

    public void filtrarHistorilaPorId ();



}

