package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CitaServicioImpl implements CitaServicio {

    private final CitaRepo citaRepo;

    private final MedicoRepo medicoRepo;

    private final PacienteRepo pacienteRepo;

    private final PacienteServicio pacienteServicio;

    private final MedicoServicio medicoServicio;

    private final EmailServicio emailServicio;


    @Override
    public int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception {

        Cita cita = new Cita();


        if(medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()) == null){

            throw new Exception("No hay ningun medico registrado con el codigo "+ medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()));
        }

        if(pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()) == null){

            throw new Exception("No hay ningun paciente con el medico" + pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()));
        }

        cita.setPaciente(pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()));
        cita.setMedico(medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()));
        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(citaDTOAdmin.fechaCita());
        cita.setMotivo(citaDTOAdmin.motivo());
        cita.setEstadoCita(EstadoCita.Programada);

        String email1 = "<h1>Cita Programada</h1><h2><p>Estimado "+ pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()).getNombre() + " Usted programo una cita para el dia " + citaDTOAdmin.fechaCita()+ " </p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "Cita Programada",
                email1,
                pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()).getEmail()));

        String email2 = "<h1>Cita Programada</h1><h2><p>Estimado "+ medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()).getNombre() + " Tiene una cita pendiente para el dia " + citaDTOAdmin.fechaCita()+ " </p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "Cita Programada",
                email2,
                medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()).getEmail()));

        return citaRepo.save(cita).getIdCita();



    }

    private InfoCitaDTO convertir(Cita cita){
        InfoCitaDTO citaGetDTO = new InfoCitaDTO(
                cita.getIdCita(),
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre(),
                cita.getFechaCita(),
                cita.getMotivo()
        );
        return citaGetDTO;
    }




    @Override
    public Cita obtenerCita(int codigoCita) throws Exception {

        Optional<Cita> cita = citaRepo.findById(codigoCita);

        if (cita.isEmpty()) {
            throw new Exception("El código " + codigoCita + " no está asociado a ninguna cita");
        }

        return cita.get();

    }

    @Override
    public int actualizarCita(CitaDTOAdmin citaDTOAdmin, int codigoCita) throws Exception {
        Optional<Cita> opcionalCita = citaRepo.findById(codigoCita);

        if(opcionalCita.isPresent()){
            Cita citaBuscada = opcionalCita.get();
            Optional<Medico> opcionalMedico = medicoRepo.findById(citaDTOAdmin.codigoMedico());
            Optional<Paciente> opcionalPaciente = pacienteRepo.findById(citaDTOAdmin.codigoPaciente());

            citaBuscada.setFechaCita(citaDTOAdmin.fechaCita());
            citaBuscada.setIdCita(citaDTOAdmin.codigoCita());
            citaBuscada.setMotivo(citaDTOAdmin.motivo());
            citaBuscada.setMedico(opcionalMedico.get());
            citaBuscada.setPaciente(opcionalPaciente.get());
            citaBuscada.setEstadoCita(citaDTOAdmin.estadoCita());

            citaRepo.save(citaBuscada);

            return citaBuscada.getIdCita();
        }else{
            throw new Exception("Cita no encontrada con el código proporcionado: " + codigoCita);
        }
    }

    @Override
    public void eliminarCita(int codigoCita) throws Exception {

        Optional<Cita> opcional = citaRepo.findById(codigoCita);

        if (opcional.isEmpty()) {
            throw new Exception("no existe una cita con el codigo " + codigoCita);
        } else {

            Cita cita = opcional.get();

            cita.setEstadoCita(EstadoCita.Cancelada);

            citaRepo.save(cita);
        }

    }

    @Override
    public List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPaciente(codigoPaciente);

        if(lista.isEmpty()){

            throw new Exception("EL paciente "+ codigoPaciente+ " no tiene citas registradas");
        }

        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita c : lista){
            respuesta.add(convertir(c));
        }
        return respuesta;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorFecha(int codigoPaciente, LocalDateTime fecha) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPorFecha(codigoPaciente,fecha);

        if(lista.isEmpty()){

            throw new Exception("No hay citas registradas en la fecha "+ fecha);
        }

        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita c : lista){
            respuesta.add(convertir(c));
        }
        return respuesta;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorMedico(int codigoPaciente, int codigoMedico) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPorMedico(codigoPaciente, codigoMedico);

        if(lista.isEmpty()){

            throw new Exception("No hay citas registradas con el medico "+ codigoMedico);
        }

        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita c : lista){
            respuesta.add(convertir(c));
        }
        return respuesta;
    }


}
