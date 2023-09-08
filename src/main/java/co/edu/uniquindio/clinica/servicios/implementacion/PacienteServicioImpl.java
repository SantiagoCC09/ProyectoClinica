package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.dto.PacienteGetDTO;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final EmailServicio emailServicio;

    @Override
    public int crearPaciente(PacienteDTO pacienteDTO) throws Exception {

        Paciente buscado = pacienteRepo.buscarPaciente(pacienteDTO.getEmail());
        if (buscado != null) {
            throw new Exception("El correo " + pacienteDTO.getEmail() + " ya está en uso");
        }
        String email= "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a la clinica Uniquindio</p>";

        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
                email,
                pacienteDTO.getEmail()));

        Paciente paciente = convertir(pacienteDTO);
        return pacienteRepo.save(paciente).getCedulaPaciente();


    }

    @Override
    public int actualizarPaciente(int cedulaPaciente, PacienteDTO pacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public int eliminiarPaciente(int cedulaPaciente) throws Exception {
        return 0;
    }

    @Override
    public Paciente obtenerPacienteU(int cedulaPaciente) throws Exception {
        return null;
    }

    @Override
    public PacienteGetDTO obtenerPaciente(int cedulaPaciente) throws Exception {
        return null;
    }

    @Override
    public void validarExiste(int cedulaPaciente) throws Exception {

    }

    private Paciente convertir(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setCedulaPaciente(pacienteDTO.getCedulaPaciente());
        paciente.setNombreCompleto(pacienteDTO.getNombreCompleto());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setCiudadResidencia(pacienteDTO.getCiudadResidencia());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setContrasenia(pacienteDTO.getContrasenia());
        paciente.setEps(pacienteDTO.getEps());
        paciente.setRh(pacienteDTO.getRh());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());

        return paciente;
    }

}
