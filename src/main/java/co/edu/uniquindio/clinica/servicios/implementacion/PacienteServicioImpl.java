package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.CitaGetDTO;
import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.dto.PQRGetDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {


    private final PacienteRepo pacienteRepo;

    private final EmailServicio emailServicio;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        Paciente buscado = pacienteRepo.buscarPacienteEmail(pacienteDTO.getEmail());
        if (buscado != null) {
            throw new Exception("El correo " + pacienteDTO.getEmail() + " ya está en uso");
        }
        String email = "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a Clinica Uniquindio</p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
                email,
                pacienteDTO.getEmail()));

        Paciente paciente = convertir(pacienteDTO);

        return pacienteRepo.save(paciente).getCodigo();

    }

    @Override
    public int editarPerfil(PacienteDTO pacienteDTO, int codigoPaciente) throws Exception {

        validarExiste(codigoPaciente);

        Paciente paciente = convertir(pacienteDTO);

        paciente.setCodigo(codigoPaciente);

        return pacienteRepo.save(paciente).getCodigo();

    }

    @Override
    public int eliminarCuenta(int codigoPaciente) throws Exception {

        validarExiste(codigoPaciente);

        pacienteRepo.deleteById(codigoPaciente);

        return codigoPaciente;
    }

    @Override
    public void enviarLinkRecuperacion() {

    }

    @Override
    public void cambiarPassword() {

    }

    @Override
    public void agendarCita() {

    }

    @Override
    public void crearPQRS() {

    }

    @Override
    public List<PQRGetDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }


    @Override
    public void responderPQRS() {

    }

    @Override
    public List<CitaGetDTO> listarCitasPaciente(String cedulaPaciente) throws Exception {

        List<Cita> lista = pacienteRepo.listarCitasPaciente(cedulaPaciente);
        List<CitaGetDTO> respuesta = new ArrayList<>();
        for (Cita p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    private CitaGetDTO convertir(Cita cita){
        CitaGetDTO citaGetDTO = new CitaGetDTO(
                cita.getIdCita(),
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre()
        );
        return citaGetDTO;
    }


    @Override
    public void filtrarCitasPorFecha() {



    }

    @Override
    public void filtrarCitasPorMedico() {

    }

    @Override
    public void verDetalleCita() {

    }

    @Override
    public void validarExiste(int codigo) throws Exception {

        boolean existe = pacienteRepo.existsById(codigo);

        if (!existe) {
            throw new Exception("El código " + codigo + " no está asociado a ningún usuario");
        }
    }

    @Override
    public void filtrarHistorialPorFecha() {

    }

    @Override
    public void filtrarHistorilaPorId() {

    }

    private Paciente convertir(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDTO.getNombreCompleto());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setPassword(pacienteDTO.getPassword());
        paciente.setRh(pacienteDTO.getRh());
        paciente.setCedula(pacienteDTO.getCedulaPaciente());
        paciente.setTelefono(pacienteDTO.getTelefono());

        return paciente;
    }


}
