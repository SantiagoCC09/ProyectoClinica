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
            if (cita.getFechaCita().isEqual(date)) {

                listaCitasPendientes.add(citaMedico);
            }

        }


        return listaCitasPendientes;
    }

    @Override
    public List <CitaDTOMedico> filtrarCitasPendientesNombrePaciente(String nombre) throws Exception {

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
            if (cita.getPaciente().getNombre().equals(nombre)) {

                listaCitasPendientes.add(citaMedico);
            }

        }


        return listaCitasPendientes;
    }

    @Override
    public List <CitaDTOMedico> filtrarCitasPendientesIdPaciente(String cedula) throws Exception {

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

            if (cita.getPaciente().getCedula().equalsIgnoreCase(cedula)){

                listaCitasPendientes.add(citaMedico);
            }

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
    public List<DiaTrabajoMedicoDTO> filtrarDisponibilidadPorFecha(LocalDateTime date) {


        List<DiaTrabajoMedico> listaDias = this.diaTrabajoMedicoRepo.findAll();
        List<DiaTrabajoMedicoDTO> listaMostrar = new ArrayList<>();
        for (DiaTrabajoMedico dia : listaDias){

            if (dia.getFecha().isEqual(date) && dia.getEstadoDia().equals(EstadoDia.IDNEFINIDO)){

                listaMostrar.add(new DiaTrabajoMedicoDTO(
                        dia.getFecha(), dia.getIdDiaTrabajo(), EstadoDia.LIBRE,
                        dia.getMedico().getCodigo()

                        )

                        );
            }

        }



    return listaMostrar;
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
    public void filtrarHistorialMedicoPorFecha(LocalDateTime date) {

    }

    @Override
    public void filtrarHistorialMedicoPorId(int idPaciente) {

    }

    @Override
    public int crearConsulta(ConsultaDTO consultaDto , RecetaDTO recetaDTO) throws Exception {

    //  citaRepo.findCitaByIdCita(idCita)

        return 0;
    }


    //Según mi plantemiento, nos ahorramos el actualizar y el eliminar
    @Override
    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception {
        return 0;
    }

    @Override
    public int eliminarConsulta(int codigoConsulta) throws Exception {
        return 0;
    }

//********************************************************************
    @Override
    public Consulta obtenerConsulta(int codigoConsulta) throws Exception {
        return null;
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
