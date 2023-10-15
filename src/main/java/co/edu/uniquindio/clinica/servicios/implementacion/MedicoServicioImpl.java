package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.ConsultaRepo;
import co.edu.uniquindio.clinica.repositorios.DiaTrabajoMedicoRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepo citaRepo;

    private final ConsultaRepo consultaRepo;

    private final MedicoRepo medicoRepo;

    private final DiaTrabajoMedicoRepo diaTrabajoMedicoRepo;


    @Override
    public void verPerfil() {

    }

    @Override
    public Medico obtenerMedico(int idMedico) throws Exception {
        Optional<Medico> medico = medicoRepo.findById(idMedico);

        if (medico.isEmpty()) {
            throw new Exception("El código " + idMedico + " no está asociado a ningún usuario");
        }

        return medico.get();
    }

    @Override
    public List <CitaDTOMedico> filtrarCitasPendientesPorFecha(LocalDateTime date) throws Exception {


        List<Cita> listaCitas = citaRepo.listarCitaPendientePorFecha(date);

        List<CitaDTOMedico> listaCitasPendientes = new ArrayList<>();

        if (listaCitas.isEmpty()) {

            throw new Exception("está vacía la lista de citas pa");
        }

        for (Cita cita : listaCitas) {

            CitaDTOMedico citaMedicoDto = new CitaDTOMedico(

                    cita.getIdCita(), cita.getPaciente().getNombre(),
                    cita.getFechaCreacion(), cita.getFechaCita(), cita.getMotivo(),
                    cita.getPaciente().getCedula(), cita.getPaciente().getCodigo()

            );
            listaCitasPendientes.add(citaMedicoDto);

        }


        return listaCitasPendientes;
    }

    @Override
    public List <CitaDTOMedico> filtrarCitasPendientesNombrePaciente(String nombre) throws Exception {

        List<Cita> listaCitas = citaRepo.listarPorNombrePaciente(nombre);

        List<CitaDTOMedico> listaCitasPendientes = new ArrayList<>();

        if (listaCitas.isEmpty()) {

            throw new Exception("está vacía la lista de citas pa");
        }

        for (Cita cita : listaCitas) {

            CitaDTOMedico citaMedicoDto = new CitaDTOMedico(

                    cita.getIdCita(), cita.getPaciente().getNombre(),
                    cita.getFechaCreacion(), cita.getFechaCita(), cita.getMotivo(),
                    cita.getPaciente().getCedula(), cita.getPaciente().getCodigo()

            );
            listaCitasPendientes.add(citaMedicoDto);

        }


        return listaCitasPendientes;
        }



    @Override
    public List <CitaDTOMedico> filtrarCitasPendientesCedulaPaciente(String cedula) throws Exception {

        List<Cita> listaCitas = citaRepo.listarPorCedulaPaciente(cedula);

        List<CitaDTOMedico> listaCitasPendientes = new ArrayList<>();

        if (listaCitas.isEmpty()) {

            throw new Exception("está vacía la lista de citas pa");
        }

        for (Cita cita : listaCitas) {

            CitaDTOMedico citaMedicoDto = new CitaDTOMedico(

                    cita.getIdCita(), cita.getPaciente().getNombre(),
                    cita.getFechaCreacion(), cita.getFechaCita(), cita.getMotivo(),
                    cita.getPaciente().getCedula(), cita.getPaciente().getCodigo()

            );
            listaCitasPendientes.add(citaMedicoDto);

        }


        return listaCitasPendientes;



    }

    @Override
    public List<CitaDTOMedico> listarCitas() throws Exception {
        List<Cita> listaCitas = citaRepo.findAll();

        List<CitaDTOMedico> listaCitasPendientes = new ArrayList<>();

        if (listaCitas.isEmpty()) {

            throw new Exception("está vacía la lista de citas pa");
        }

        for (Cita cita : listaCitas) {

            CitaDTOMedico citaMedico = new CitaDTOMedico(

                    cita.getIdCita(), cita.getPaciente().getNombre(),
                    cita.getFechaCreacion(), cita.getFechaCita(), cita.getMotivo(),
                    cita.getPaciente().getCedula(), cita.getPaciente().getCodigo()

            );

                listaCitasPendientes.add(citaMedico);

        }


        return listaCitasPendientes;
    }

    @Override
    public String atenderCitaSeleccionada(CitaDTOAdmin citaDTOAdmin) {

        String respuesta = "no se ha podido completar la cita";

        Optional <Cita> opcional = Optional.ofNullable(citaRepo.findCitaByIdCita(citaDTOAdmin.codigoCita()));

        if (opcional.isPresent()){

            opcional.get().setEstadoCita(EstadoCita.Completada);
            respuesta = "se ha completado la cita";
        }

        return respuesta;
    }

    @Override
    public DiaTrabajoMedicoDTO filtrarDisponibilidadPorFecha(LocalDateTime date) throws Exception {

        DiaTrabajoMedicoDTO diaDto = null;

        Optional <DiaTrabajoMedico> dia = Optional.ofNullable(diaTrabajoMedicoRepo.findDiaTrabajoMedicoByFecha(date));

        if (dia.isPresent()){

            diaDto = new DiaTrabajoMedicoDTO(
                    dia.get().getFecha(), dia.get().getIdDiaTrabajo(), dia.get().getEstadoDia()
                    ,dia.get().getMedico().getCodigo()

            );

        }


        if (diaDto == null){

            throw new Exception("no se encontró el día");
        }


        return diaDto;

        }


    @Override
    public String reservarDiaLibre(LocalDateTime date) {

        String respuesta = "no se puede, dado que el día no es libre";
        DiaTrabajoMedico dia = diaTrabajoMedicoRepo.findDiaTrabajoMedicoByFecha(date);



        return null;
    }

    @Override
    public String deshacerDiaLibre(LocalDateTime date) {
        return null;
    }

    @Override
    public List <ConsultaDTO> filtrarHistorialMedicoPorFecha(LocalDateTime date) {

        List <Consulta> consultas = consultaRepo.findConsultaByFecha(date);

        List <ConsultaDTO> consultasMostrar = new ArrayList<>();


        for (Consulta consulta : consultas){

            ConsultaDTO consultaDto = new ConsultaDTO(
                    consulta.getIdConsulta(),consulta.getTratamiento(),
                    consulta.getNotasMedicas(),consulta.getDetallesConsulta()
                    ,consulta.getCita().getIdCita()
            );

            consultasMostrar.add(consultaDto);


        }
    return consultasMostrar;
    }

    @Override
    public List <ConsultaDTO> filtrarHistorialMedicoPorId(String cedulaPaciente) {

        List <Consulta> consultas = consultaRepo.findByPacienteId (cedulaPaciente);

        List <ConsultaDTO> consultasMostrar = new ArrayList<>();


        for (Consulta consulta : consultas){

            ConsultaDTO consultaDto = new ConsultaDTO(
                    consulta.getIdConsulta(),consulta.getTratamiento(),
                    consulta.getNotasMedicas(),consulta.getDetallesConsulta()
                    ,consulta.getCita().getIdCita()
            );

            consultasMostrar.add(consultaDto);


        }
        return consultasMostrar;
    }

    //Según mi plantemiento, nos ahorramos el actualizar y el eliminar
    @Override
    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception {
        return 0;
    }

    @Override
    public int agregarMedicamentoReceta(MedicamentoDTO medicamentoDTO, RecetaDTO recetaDTO) {



        return 0;
    }

    @Override
    public int eliminarMedicamentoReceta(int idMedicamento, RecetaDTO recetaDTO) {



        return 0;
    }

    @Override
    public int crearReceta(RecetaDTO recetaDTO) {



        return 0;
    }

    @Override
    public int actualizarReceta(RecetaDTO recetaDTO) {
        return 0;
    }
}
