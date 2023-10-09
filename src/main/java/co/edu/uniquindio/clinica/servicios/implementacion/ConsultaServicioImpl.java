package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.ConsultaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultaServicioImpl implements ConsultaServicio {

    private final CitaRepo citaRepo;
    private final ConsultaRepo consultaRepo;

    @Override
    public int crearConsulta(int idCita) throws Exception {
        return 0;
    }
}
