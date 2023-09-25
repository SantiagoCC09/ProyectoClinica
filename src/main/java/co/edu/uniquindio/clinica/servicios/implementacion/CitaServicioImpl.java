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







}
