package co.edu.uniquindio.clinica.servicios.interfaces;


import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;

import java.util.Date;

public interface MedicoServicio {



    public void verPerfil();

    public void filtrarCitasPendientesPorFecha(Date date);

    public void filtrarCitasPendientesNombrePaciente(String nombre);

    public void filtrarCitasPendientesIdPaciente(int idPaciente);

    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin);

    public void filtrarDisponibilidadPorFecha(Date date);

    public String reservarDiaLibre(Date date);

    public String deshacerDiaLibre(Date date);

    public void filtrarHistorialMedicoPorFecha(Date date);

    public void filtrarHistorialMedicoPorId(int idPaciente);

    //El médico crea y gestiona las consultas
    public int crearConsulta(ConsultaDTO consultaDto) throws Exception;

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    public int eliminarConsulta(int codigoConsulta) throws Exception;

    public Consulta obtenerConsulta(int codigoConsulta) throws Exception;

}
