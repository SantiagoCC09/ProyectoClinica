package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;

public interface ConsultaServicio {

    int crearConsulta(ConsultaDTO consultaDTO) throws Exception;

    public void eliminarConsulta(int codigoConsulta) throws Exception;

    public Consulta obtenerConsulta(int codigoConsulta) throws Exception;





}
