package co.edu.uniquindio.clinica.servicios.interfaces;


import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;

public interface MedicoServicio {



    public void verPerfil();

    public void filtrarCitasPendientesPorFecha();

    public void filtrarCitasPendientesNombreCliente();

    public void filtrarCitasPendientesIdCLiente();

    public void atenderCitaSeleccionada();

    public void filtrarDisponibilidadPorFecha();

    public void reservarDiaLibre();

    public void deshacerDiaLibre();

    public void filtrarHistorialMedicoPorFecha();

    public void filtrarHistorialMedicoPorId();

    //El médico crea y gestiona las consultas
    public int crearConsulta(ConsultaDTO consultaDto) throws Exception;

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    public int eliminarConsulta(int codigoConsulta) throws Exception;

    public Consulta obtenerConsulta(int codigoConsulta) throws Exception;

}
