package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.entidades.EstadoUsuario;
import co.edu.uniquindio.clinica.entidades.PQR;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {


    private final PacienteRepo pacienteRepo;

    private final CitaRepo citaRepo;

    private final PasswordEncoder passwordEncoder;

    private final EmailServicio emailServicio;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        Paciente buscado = pacienteRepo.buscarPacienteEmail(pacienteDTO.email());
        if (buscado != null) {
            throw new Exception("El correo " + pacienteDTO.email() + " ya está en uso");
        }
        String email = "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a Clinica Uniquindio</p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "TestMail-Html",
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

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigoPaciente);
        }

        Paciente buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.ESTADO_INACTIVO);
        pacienteRepo.save( buscado );

        //medicoRepo.delete(buscado);

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
    public int crearPqr(PQRDTO pqrDto) throws Exception {
        return 0;
    }

    @Override
    public void actualizarPqr(PQRDTO pqrDto, int idPqr) throws Exception {

    }

    @Override
    public void eliminarPqr(int idPqr) throws Exception {

    }

    @Override
    public PQR obtenerPqr(int idPqr) throws Exception {
        return null;
    }


    @Override
    public List<InfoPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }


    @Override
    public void responderPQRS() {

    }

    @Override
    public List<InfoCitaDTO> listarCitasPaciente(String cedulaPaciente) throws Exception {

        List<Cita> lista = pacienteRepo.listarCitasPaciente(cedulaPaciente);
        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    private InfoCitaDTO convertir(Cita cita){
        InfoCitaDTO citaGetDTO = new InfoCitaDTO(
                cita.getIdCita(),
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre()
        );
        return citaGetDTO;
    }


    @Override
    public List<InfoCitaDTO> filtrarCitasPorFecha(Date fecha, String cedulaPaciente) {

        List<Cita> lista = citaRepo.listarCitasPorFecha(fecha);
        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;


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

        paciente.setNombre(pacienteDTO.nombreCompleto());
        paciente.setEmail(pacienteDTO.email());
        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setPassword(pacienteDTO.password());
        paciente.setRh(pacienteDTO.rh());
        paciente.setCedula(pacienteDTO.cedulaPaciente());
        paciente.setTelefono(pacienteDTO.telefono());

        return paciente;
    }

    @Override
    public int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception {

        Cita cita = new Cita();

        cita.setPaciente(this.obtenerPaciente(citaDTOAdmin.codigoPaciente()));
        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(citaDTOAdmin.fechaCita());
        cita.setMotivo(citaDTOAdmin.motivo());
        return citaRepo.save(cita).getIdCita();
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
    public Cita obtenerCita(int codigoCita) throws Exception {




        return null;
    }


}
