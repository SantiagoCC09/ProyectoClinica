package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CitaServicioImpl implements CitaServicio {

    private final CitaRepo citaRepo;

    private final PacienteServicio pacienteServicio;




    @Override
    public int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception {

        Cita cita = new Cita();

        cita.setPaciente(pacienteServicio.obtenerPaciente(citaDTOAdmin.cedulaPaciente()));
        cita.setFechaCita(citaDTOAdmin.fecha());

        return 0;
    }

    @Override
    public int actualizarCita() throws Exception {
        return 0;
    }

    @Override
    public int eliminarCita() throws Exception {
        return 0;
    }

    @Override
    public InfoCitaDTO obtenerCita() throws Exception {
        return null;
    }
}
