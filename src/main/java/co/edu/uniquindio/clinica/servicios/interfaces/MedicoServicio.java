package co.edu.uniquindio.clinica.servicios.interfaces;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.entidades.Medico;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MedicoServicio {


    public void verPerfil();

    Medico obtenerMedico(int idMedico) throws Exception;

    public List<CitaDTOMedico> filtrarCitasPendientesPorFecha(Date date,int codigoMedico) throws Exception;

    public List<CitaDTOMedico> filtrarCitasPendientesNombrePaciente(String nombre, int codigoMedico) throws Exception;

    public List<CitaDTOMedico> filtrarCitasPendientesCedulaPaciente(String cedula, int codigoMedico) throws Exception;

    public List<CitaDTOMedico> listarCitas(int codigoMedico) throws Exception;

    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin);

    public DiaTrabajoMedicoDTO filtrarDisponibilidadPorFecha(Date date) throws Exception;

    public String reservarDiaLibre(Date date);

    public String deshacerDiaLibre(Date date);

    public List <ConsultaDTO> filtrarHistorialMedicoPorFecha(Date date);

    public List <ConsultaDTO> filtrarHistorialMedicoPorId(String cedulaPaciente);

    //El médico crea y gestiona las consultas

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    int agregarMedicamentoReceta (MedicamentoDTO medicamentoDTO , RecetaDTO recetaDTO) throws Exception;

    int eliminarMedicamentoReceta (int idMedicamento, RecetaDTO recetaDTO) throws Exception;

    int crearReceta (RecetaDTO recetaDTO);

    int actualizarReceta (RecetaDTO recetaDTO) throws Exception;


    MedicoDTO obtenerMedicoDTO(int idMedico) throws Exception;
}
