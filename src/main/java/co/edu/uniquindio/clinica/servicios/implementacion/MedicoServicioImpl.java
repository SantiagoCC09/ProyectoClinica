package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
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

    private final RecetaRepo recetaRepo;

    private final MedicamentoRepo medicamentoRepo;

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
    public List <CitaDTOMedico> filtrarCitasPendientesPorFecha(Date date) throws Exception {


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
    public DiaTrabajoMedicoDTO filtrarDisponibilidadPorFecha(Date date) throws Exception {

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
    public String reservarDiaLibre(Date date) {

        String respuesta = "no se puede, dado que el día no es libre";
        DiaTrabajoMedico dia = diaTrabajoMedicoRepo.findDiaTrabajoMedicoByFecha(date);



        return null;
    }

    @Override
    public String deshacerDiaLibre(Date date) {
        return null;
    }


    @Override
    public List <ConsultaDTO> filtrarHistorialMedicoPorFecha(Date date) {

        List <Consulta> consultas = consultaRepo.findConsultaByFecha(date);

        List <ConsultaDTO> consultasMostrar = new ArrayList<>();


        for (Consulta consulta : consultas){

            ConsultaDTO consultaDto = new ConsultaDTO(
                    consulta.getTratamiento(),
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
                    consulta.getTratamiento(),
                    consulta.getNotasMedicas(),consulta.getDetallesConsulta()
                    ,consulta.getCita().getIdCita()
            );

            consultasMostrar.add(consultaDto);


        }
        return consultasMostrar;
    }

   // métodos de la funcionalidad extra
    @Override
    public int actualizarConsulta(ConsultaDTO consultaDtoint, int codigoConsulta) throws Exception {





        return 0;
    }

    @Override
    public int agregarMedicamentoReceta(MedicamentoDTO medicamentoDTO, RecetaDTO recetaDTO) throws Exception {

        Medicamento medicamento = new Medicamento();

        Optional <Receta> recetaBuscada = recetaRepo.findById(recetaDTO.idReceta());

        Receta receta = new Receta();
        if (recetaBuscada.isPresent()){

            medicamento.setReceta(recetaBuscada.get());
            medicamento.setNombre(medicamentoDTO.nombre());
            medicamento.setEfectosSecundarios(medicamentoDTO.efectosSecundarios());

            receta = recetaRepo.save(recetaBuscada.get());

        }else{

            throw new Exception("la receta es nula, entonces no se puede agregar medicamentos a ella");
        }



        return receta.getIdReceta();
    }

    @Override
    public int eliminarMedicamentoReceta(int idMedicamento, RecetaDTO recetaDTO) throws Exception {

            Optional <Medicamento> medicamento = medicamentoRepo.findById(idMedicamento);
            Optional <Receta> recetaBuscada = recetaRepo.findById(recetaDTO.idReceta());
            Receta receta = new Receta();
            if (recetaBuscada.isPresent() && medicamento.isPresent()){

                receta = recetaBuscada.get();
                List <Medicamento> listaMedicamentos = receta.getListaMedicamentos();

                for (Medicamento listaMedicamento : listaMedicamentos) {

                    if (listaMedicamento.getIdMedicamento() == idMedicamento) {

                        listaMedicamento.setEstadoMedicamento(EstadoMedicamento.DESHABILITADO);
                    }

                }




            }else{

                throw new Exception("la receta no se encontró para poder actualizarla");
            }

            Receta recetaGuardada = recetaRepo.save(receta);

        return recetaGuardada.getIdReceta();
    }

    @Override
    public int crearReceta(RecetaDTO recetaDTO) {

            Optional <Consulta> consulta = consultaRepo.findById(recetaDTO.idConsulta());
            Receta receta = new Receta();
            receta.setDescripcion(recetaDTO.descripcion());
            receta.setInstrucciones(recetaDTO.instrucciones());
            consulta.ifPresent(receta::setConsulta);

           Receta recetaGuaradada = recetaRepo.save(receta);



        return  recetaGuaradada.getIdReceta();
    }

    @Override
    public int actualizarReceta(RecetaDTO recetaDTO) throws Exception {
        Optional <Consulta> consulta = consultaRepo.findById(recetaDTO.idConsulta());
        Optional <Receta> recetaBuscada = recetaRepo.findById(recetaDTO.idReceta());
        Receta receta = new Receta();
        if (recetaBuscada.isPresent()){

            receta = recetaBuscada.get();
            receta.setDescripcion(recetaDTO.descripcion());
            receta.setInstrucciones(recetaDTO.instrucciones());
            consulta.ifPresent(receta::setConsulta);
        }else{

            throw new Exception("la receta no se encontró para poder actualizarla");
        }

        Receta recetaGuardada = recetaRepo.save(receta);

        return recetaGuardada.getIdReceta();
    }
}
