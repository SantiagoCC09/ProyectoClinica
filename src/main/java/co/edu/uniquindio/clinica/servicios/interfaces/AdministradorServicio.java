package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.MedicoDTO;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception;

    int eliminarMedico(int codigoMedico) throws Exception;

    void listarMedicos();

    void obtenerMedico();

    void listarPQRS();

    void responderPQRS();

    void verDetallePQRS();



}
