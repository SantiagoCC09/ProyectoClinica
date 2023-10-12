package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.ConsultaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

            throw new Exception("no hay ninguna cita asociada al codigo "+ consultaDTO.idConsulta());
        }

        Consulta consulta = new Consulta();

        consulta.setCita(citaServicio.obtenerCita(consultaDTO.idCita()));
        consulta.setNotasMedicas(consultaDTO.notasMedico());
        consulta.setDetallesConsulta(consultaDTO.detallesConsulta());
        consulta.setTratamiento(consultaDTO.tratamiento());



        return consultaRepo.save(consulta).getIdConsulta();
    }
}
