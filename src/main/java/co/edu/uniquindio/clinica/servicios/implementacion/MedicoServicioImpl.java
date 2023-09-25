package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;

import java.util.Date;

public class MedicoServicioImpl implements MedicoServicio {
    @Override
    public void verPerfil() {

    }

    @Override
    public void filtrarCitasPendientesPorFecha(Date date) {

    }

    @Override
    public void filtrarCitasPendientesNombrePaciente(String nombre) {

    }

    @Override
    public void filtrarCitasPendientesIdPaciente(int idPaciente) {

    }

    @Override
    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin) {
        return null;
    }

    @Override
    public void filtrarDisponibilidadPorFecha(Date date) {

    }

    @Override
    public String reservarDiaLibre(Date date) {
        return null;
    }

    @Override
    public String deshacerDiaLibre(Date date) {
        return null;
    }

    @Override
    public void filtrarHistorialMedicoPorFecha(Date date) {

    }

    @Override
    public void filtrarHistorialMedicoPorId(int idPaciente) {

    }

    @Override
    public int crearConsulta(ConsultaDTO consultaDto) throws Exception {
        return 0;
    }

    @Override
    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception {
        return 0;
    }

    @Override
    public int eliminarConsulta(int codigoConsulta) throws Exception {
        return 0;
    }

    @Override
    public Consulta obtenerConsulta(int codigoConsulta) throws Exception {
        return null;
    }
}
