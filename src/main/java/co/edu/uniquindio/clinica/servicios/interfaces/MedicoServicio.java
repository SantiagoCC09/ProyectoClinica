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

    public List<CitaDTOMedico> filtrarCitasPendientesPorFecha(LocalDateTime date) throws Exception;

    public List<CitaDTOMedico> filtrarCitasPendientesNombrePaciente(String nombre) throws Exception;

    public List<CitaDTOMedico> filtrarCitasPendientesCedulaPaciente(String cedula) throws Exception;

    public List<CitaDTOMedico> listarCitas() throws Exception;

    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin);

    public DiaTrabajoMedicoDTO filtrarDisponibilidadPorFecha(LocalDateTime date) throws Exception;

    public String reservarDiaLibre(LocalDateTime date);

    public String deshacerDiaLibre(LocalDateTime date);

    public List <ConsultaDTO> filtrarHistorialMedicoPorFecha(LocalDateTime date);

    public List <ConsultaDTO> filtrarHistorialMedicoPorId(String cedulaPaciente);

    //El médico crea y gestiona las consultas

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    int agregarMedicamentoReceta (MedicamentoDTO medicamentoDTO , RecetaDTO recetaDTO);

    int eliminarMedicamentoReceta (int idMedicamento, RecetaDTO recetaDTO);

    int crearReceta (RecetaDTO recetaDTO);

    int actualizarReceta (RecetaDTO recetaDTO);



}
