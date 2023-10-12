package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.entidades.EstadoCita;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CitaServicioImpl implements CitaServicio {

    private final CitaRepo citaRepo;

    private final PacienteServicio pacienteServicio;

    private final MedicoServicio medicoServicio;


    @Override
    public int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception {

        Cita cita = new Cita();

        cita.setPaciente(pacienteServicio.obtenerPaciente(citaDTOAdmin.codigoPaciente()));
        cita.setMedico(medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()));
        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(citaDTOAdmin.fechaCita());
        cita.setMotivo(citaDTOAdmin.motivo());
        cita.setEstadoCita(EstadoCita.Programada);
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
        return 0;
    }

    @Override
    public int eliminarCita(int codigoCita) throws Exception {
        return 0;
    }

    @Override
    public List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPaciente(codigoPaciente);

        if(lista.isEmpty()){
            throw new Exception("EL paciente "+ codigoPaciente+ "no tiene citas registradas");
        }

        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita c : lista){
            respuesta.add(convertir(c));
        }
        return respuesta;
    }

    @Override
    public List<InfoCitaDTO> filtrarCitasPorFecha(int codigoPaciente, Date fecha) throws Exception {

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
