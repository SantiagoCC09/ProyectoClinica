package co.edu.uniquindio.clinica.servicios.interfaces;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.Consulta;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MedicoServicio {



    public void verPerfil();

    public List<CitaDTOMedico> filtrarCitasPendientesPorFecha(LocalDateTime date) throws Exception;

    public List <CitaDTOMedico> filtrarCitasPendientesNombrePaciente(String nombre) throws Exception;

    public List <CitaDTOMedico> filtrarCitasPendientesIdPaciente(String cedula) throws Exception;

    public List <CitaDTOMedico> listarCitas() throws Exception;
    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin);

    public void filtrarDisponibilidadPorFecha(Date date);

    public String reservarDiaLibre(Date date);

    public String deshacerDiaLibre(Date date);

    public void filtrarHistorialMedicoPorFecha(Date date);

    public void filtrarHistorialMedicoPorId(int idPaciente);

    //El médico crea y gestiona las consultas
    public int crearConsulta(ConsultaDTO consultaDto, RecetaDTO recetaDTO) throws Exception;

    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception;

    public int eliminarConsulta(int codigoConsulta) throws Exception;

    public Consulta obtenerConsulta(int codigoConsulta) throws Exception;

    int agregarMedicamentoReceta (MedicamentoDTO medicamentoDTO , RecetaDTO recetaDTO);

    int eliminarMedicamentoReceta (int idMedicamento, RecetaDTO recetaDTO);

    int crearReceta (RecetaDTO recetaDTO);

    int actualizarReceta (RecetaDTO recetaDTO);



}
