package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.entidades.EstadoCita;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.ConsultaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.lang.Object;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultaServicioImpl implements ConsultaServicio {

    private final CitaRepo citaRepo;
    private final ConsultaRepo consultaRepo;

    private final CitaServicio citaServicio;

    @Override
    public int crearConsulta(ConsultaDTO consultaDTO) throws Exception {


        Cita cita = citaRepo.findCitaByIdCita(consultaDTO.idCita());

        if (cita == null){

            throw new Exception("no hay ninguna cita asociada al codigo "+ consultaDTO.idCita());
        }

        Consulta consulta = new Consulta();

        consulta.setCita(citaServicio.obtenerCita(consultaDTO.idCita()));
        cita.setEstadoCita(EstadoCita.Completada);
        consulta.setNotasMedicas(consultaDTO.notasMedico());
        consulta.setDetallesConsulta(consultaDTO.detallesConsulta());
        consulta.setTratamiento(consultaDTO.tratamiento());


        return consultaRepo.save(consulta).getIdConsulta();
    }

    @Override
    public void eliminarConsulta(int codigoConsulta) throws Exception {
        Optional<Consulta> opcionalConsulta = consultaRepo.findById(codigoConsulta);

        if(opcionalConsulta.isEmpty()){
            throw new Exception("no existe una consulta con el codigo " + codigoConsulta);
        }else{
            Consulta consulta= opcionalConsulta.get();
            consultaRepo.save(consulta);
        }


    }

    @Override
    public Consulta obtenerConsulta(int codigoConsulta) throws Exception {
        Optional<Consulta> opcionalConsulta = consultaRepo.findById(codigoConsulta);
        if(opcionalConsulta.isEmpty()){
            throw new Exception("El código " + codigoConsulta + " no está asociado a ninguna consulta");
        }
        return opcionalConsulta.get();

    }


}
