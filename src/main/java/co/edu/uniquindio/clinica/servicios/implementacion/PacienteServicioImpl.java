package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
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

    private final MedicoServicio medicoServicio;

    private final CitaRepo citaRepo;

    private final PasswordEncoder passwordEncoder;

    private final EmailServicio emailServicio;

    private final PQRSRepo pqrsRepo;

    private final AdministradorRepo administradorRepo;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        Paciente buscado = pacienteRepo.buscarPacienteEmail(pacienteDTO.email());
        if (buscado != null) {
            throw new Exception("El correo " + pacienteDTO.email() + " ya está en uso");
        }
        String email = "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a Clinica Uniquindio</p></h2>";

        emailServicio.enviarEmail(new EmailDTO(
                pacienteDTO.email(),
                "Creacion De cuenta ClinicaUQ",
                email));


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
                paciente.getEmail(),
                "Desactivacion De cuenta ClinicaUQ",
                email));

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
    public int crearPqr(PQRDTOPaciente pqrDto) throws Exception {


        Optional <Administrador> opcionalAdmin = administradorRepo.findById(pqrDto.codigoAdministrador());
        Optional <Paciente> opcionalPaciente = Optional.ofNullable(this.obtenerPaciente(pqrDto.codigoPaciente()));

        PQR pqr = new PQR();

        pqr.setFecha(pqrDto.fecha());
        pqr.setDescripcion(pqrDto.descripcion());
        pqr.setMotivo(pqrDto.motivo());
        pqr.setEstado(pqrDto.estado());
        pqr.setFechaCreacion(pqrDto.fechaCreacion());
        pqr.setAdministrador(opcionalAdmin.get());
        pqr.setPaciente(opcionalPaciente.get());

        PQR pqrGuardada = this.pqrsRepo.save(pqr);



        return pqrGuardada.getIdPqr();
    }

    @Override
    public void actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception {


        Optional <PQR> opcional = pqrsRepo.findById(idPqr);





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
    public List<InfoCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPaciente(codigoPaciente);
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
                cita.getMedico().getNombre(),
                cita.getFechaCita(),
                cita.getMotivo()
        );
        return citaGetDTO;
    }


    @Override
    public List<InfoCitaDTO> filtrarCitasPorFecha(int codigoPaciente, Date fecha) throws Exception {

        List<Cita> lista = citaRepo.listarCitasPorFecha(codigoPaciente,fecha);

        if(lista.isEmpty()){

            throw new Exception("No hay citas registradas en la fecha "+ fecha);
        }

        List<InfoCitaDTO> respuesta = new ArrayList<>();
        for (Cita p : lista){
            respuesta.add(convertir(p));
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
        for (Cita p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;

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
        paciente.setCiudadResidencia(pacienteDTO.ciudadResidencia());
        paciente.setPassword(pacienteDTO.password());
        paciente.setCiudad(pacienteDTO.ciudadResidencia());
        paciente.setRh(pacienteDTO.rh());
        paciente.setCedula(pacienteDTO.cedulaPaciente());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setEstado(EstadoUsuario.ESTADO_ACTIVO);
        paciente.setEps(pacienteDTO.eps());
        paciente.setUrlFoto(pacienteDTO.URL_Foto());

        return paciente;
    }

    @Override
    public int crearCita(CitaDTOAdmin citaDTOAdmin) throws Exception {

        Cita cita = new Cita();

        cita.setPaciente(this.obtenerPaciente(citaDTOAdmin.codigoPaciente()));
        cita.setMedico(medicoServicio.obtenerMedico(citaDTOAdmin.codigoMedico()));
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
