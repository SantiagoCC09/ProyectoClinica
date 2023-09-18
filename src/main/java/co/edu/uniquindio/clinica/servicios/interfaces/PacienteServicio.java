package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.PacienteDTO;

public interface PacienteServicio {

    String registrarse(PacienteDTO pacienteDTO);

    String editarPerfil(PacienteDTO pacienteDTO);

    void eliminarCuenta();

    void enviarLinkRecuperacion();

    void cambiarPassword();

    void agendarCita();

    void crearPQRS();

    void listarPQRSPaciente();

    void responderPQRS();

    void listarCitasPaciente();

    void filtrarCitasPorFecha();

    void filtrarCitasPorMedico();

    void verDetalleCita();

     void validarExiste(int cedulaPaciente) throws Exception;
    public void actualizarDatosPersonales();

    public void agregarCita();

    public void confirmarCita();

    public void cancelarCita();

    public void actualizarCita();


    public void enviarPqr();


    public void filtrarHistorialPorFecha();

    public void filtrarHistorilaPorId ();



}
