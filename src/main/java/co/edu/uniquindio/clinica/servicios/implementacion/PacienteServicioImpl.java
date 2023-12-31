package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {


    private final PacienteRepo pacienteRepo;

    private final PasswordEncoder passwordEncoder;

    private final EmailServicio emailServicio;

    private final PQRSRepo pqrsRepo;

    private final CitaRepo citaRepo;
    private final AdministradorRepo administradorRepo;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        Paciente buscado = pacienteRepo.buscarPacienteEmail(pacienteDTO.email());

        if (buscado != null) {
            throw new Exception("El correo " + pacienteDTO.email() + " ya está en uso");
        }
        String email = "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a Clinica Uniquindio </p></h2>" + pacienteDTO.nombreCompleto() +"<img src='https://ibb.co/h9v2hjn' width='300' height='200'>";

        emailServicio.enviarEmail(new EmailDTO(
                "Creacion De cuenta ClinicaUQ",
                email,
                pacienteDTO.email()));


        Paciente paciente = convertir(pacienteDTO);

        paciente.setPassword(passwordEncoder.encode(paciente.getPassword()));

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
    public void eliminarCuenta(int codigoPaciente) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigoPaciente);
        Paciente paciente = obtenerPaciente(codigoPaciente);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un paciente con el código " + codigoPaciente);
        }
        String email = "<h1>Su cuenta ha sido desactivada</h1><h2><p>Clinica Uniquindio ha desactivado su cuenta</p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "Desactivacion De cuenta ClinicaUQ",
                email,
                paciente.getEmail()));

        Paciente buscado = opcional.get();

        buscado.setEstado(EstadoUsuario.ESTADO_INACTIVO);

        pacienteRepo.save(buscado);


    }

    @Override
    public Paciente obtenerPaciente(int codigoPaciente) throws Exception {

        Optional<Paciente> paciente = pacienteRepo.findById(codigoPaciente);

        if (paciente.isEmpty()) {
            throw new Exception("El código " + codigoPaciente + " no está asociado a ningún usuario");
        }

        return paciente.get();

    }

    @Override
    public void enviarLinkRecuperacion() {

    }


    @Override
    public InfoCitaDTO verDetalleCita(int idCita) throws Exception {

        Optional <Cita> opcional = citaRepo.findById(idCita);

        if (opcional.isEmpty()){

            throw new Exception("no hay pqr con la id" +idCita);
        }

        Cita buscado = opcional.get();


        return new InfoCitaDTO(

                buscado.getIdCita(), buscado.getPaciente().getNombre(),buscado.getMedico().getNombre(),
                buscado.getFechaCita(),buscado.getMotivo()
        );

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

    @Override
    public PacienteDTO obtenerPacienteDTO(int codigoPaciente) throws Exception {
        PacienteDTO pacienteFinal = null;
        Paciente paciente = this.obtenerPaciente(codigoPaciente);
        if (paciente != null){

            PacienteDTO pacienteDTO =  new PacienteDTO(
            paciente.getCedula(), paciente.getEmail(), paciente.getPassword(),
                    paciente.getNombre(), paciente.getTelefono(), paciente.getCiudad(),
                    paciente.getFechaNacimiento(),paciente.getRh(),paciente.getEps(),
                    paciente.getUrlFoto(),paciente.getAlergias()



            );
        pacienteFinal = pacienteDTO;

        }

        return pacienteFinal;
    }

    private Paciente convertir(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();

        paciente.setNombre(pacienteDTO.nombreCompleto());
        paciente.setEmail(pacienteDTO.email());
        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setPassword(pacienteDTO.password());
        paciente.setCiudad(pacienteDTO.ciudadResidencia());
        paciente.setRh(pacienteDTO.rh());
        paciente.setCedula(pacienteDTO.cedulaPaciente());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setEstado(EstadoUsuario.ESTADO_ACTIVO);
        paciente.setEps(pacienteDTO.eps());
        paciente.setUrlFoto(pacienteDTO.URL_Foto());
        paciente.setAlergias(pacienteDTO.alergias());


        return paciente;
    }

}
