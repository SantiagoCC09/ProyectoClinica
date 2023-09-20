package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;

public interface ConsultaServicio {

    public int crearConsulta(ConsultaDTO consultaDto) throws Exception;

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    public int eliminarConsulta(int codigoConsulta) throws Exception;

    public Consulta obtenerConsulta(int codigoConsulta) throws Exception;



}
