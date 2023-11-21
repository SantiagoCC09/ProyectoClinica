package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {


    private final MedicoRepo medicoRepo;

    private final AdministradorRepo administradorRepo;

    private final EmailServicio emailServicio;

    private final PQRSRepo pqrsRepo;

    private final CitaRepo citaRepo;

    private final RespuestaRepo respuestaRepo;

    private final DiaTrabajoMedicoRepo diaTrabajoMedicoRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {

        Medico medicoNuevo = new Medico();

        medicoNuevo.setCiudad(medicoDTO.ciudad());
        medicoNuevo.setNombre(medicoDTO.nombre());
        medicoNuevo.setCedula(medicoDTO.cedula());
        medicoNuevo.setTelefono(medicoDTO.telefono());
        medicoNuevo.setUrlFoto(medicoDTO.URL_foto());
        medicoNuevo.setEspecialidad(medicoDTO.especialidad());
        medicoNuevo.setEstado(EstadoUsuario.ESTADO_ACTIVO);
        medicoNuevo.setPassword(passwordEncoder.encode(medicoDTO.password()));
        medicoNuevo.setEmail(medicoDTO.correo());

        if (estaRepetidoCorreo(medicoDTO.correo())) {

            throw new Exception("El correo está repetido");

        }

        if (estaRepetidoCedula(medicoDTO.cedula())) {

            throw new Exception("la cedula está repetida");

        }

        String email = "<h1>Creacion de cuenta exitosa</h1><h2><p>Bienvenido a Clinica Uniquindio Doctor </p>"+ medicoDTO.nombre() + "</h2><img src='https://ibb.co/h9v2hjn' width='1080' height='1080'>";

        emailServicio.enviarEmail(new EmailDTO(
                "Ingreso De Medico ClinicaUQ",
                email,
                medicoDTO.correo()));

        Medico medicoRegistrado = medicoRepo.save(medicoNuevo);


        medicoRegistrado.setPassword(passwordEncoder.encode(medicoRegistrado.getPassword()));

        asignarHorariosMedico( medicoNuevo, medicoDTO.horarios() );
        
        return medicoRegistrado.getCodigo();
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<DiaTrabajoMedicoDTO> horarios) {

        for( DiaTrabajoMedicoDTO h : horarios ){

            DiaTrabajoMedico hm = new DiaTrabajoMedico();
            hm.setFecha( h.fecha() );
            hm.setEstadoDia( h.estadoDia() );
            hm.setMedico( medicoNuevo );
            diaTrabajoMedicoRepo.save(hm);

        }

    }


    private boolean estaRepetidoCorreo(String correo) {


         return medicoRepo.findByEmail(correo)!=null;
    }

    private boolean estaRepetidoCedula(String cedula) {



        return medicoRepo.findByCedula(cedula)!=null;

    }

    @Override
    public int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception {
            Optional<Medico> opcional = medicoRepo.findById(codigoMedico);

            if (opcional.isPresent()) {
                Medico medicoBuscado = opcional.get();

                // Actualizamos los campos del médico con los valores del DTO
                medicoBuscado.setCiudad(medicoDTO.ciudad());
                medicoBuscado.setNombre(medicoDTO.nombre());
                medicoBuscado.setCedula(medicoDTO.cedula());
                medicoBuscado.setTelefono(medicoDTO.telefono());
                medicoBuscado.setUrlFoto(medicoDTO.URL_foto());
                medicoBuscado.setEspecialidad(medicoDTO.especialidad());
                medicoBuscado.setEmail(medicoDTO.correo());
                medicoBuscado.setPassword(passwordEncoder.encode(medicoDTO.password()));

                medicoRepo.save(medicoBuscado);

                return medicoBuscado.getCodigo();
            } else {
                throw new Exception("Médico no encontrado con el código proporcionado: " + codigoMedico);
            }


    }

    @Override
    public void eliminarMedico(int codigoMedico) throws Exception{


        Optional<Medico> opcional =medicoRepo.findById(codigoMedico);

       if (opcional.isEmpty()){


           throw new Exception("no existe médico con ese id");
       }else{

           Medico buscado = opcional.get();

           //medicoRepo.delete(buscado);  delete from medico where medigo.codigo =111
           buscado.setEstado(EstadoUsuario.ESTADO_INACTIVO);

           medicoRepo.save(buscado);
       }

    }

    @Override
    public List<MedicoDTO> listarMedicos()throws Exception {

        List<Medico> medicos = medicoRepo.findAll();

        if (medicos.isEmpty()){

            throw new Exception("No hay ningun medico registrado");

        }
        List <MedicoDTO> respuesta = new ArrayList<>();


        for (Medico m : medicos){

            respuesta.add( new MedicoDTO(
                    m.getNombre(),m.getCedula(),m.getCiudad(),m.getUrlFoto(),
                    m.getEspecialidad(),m.getTelefono(),m.getEmail(),m.getPassword(), new ArrayList<>()

            ));



        }

        return respuesta;
    }

    @Override
    public MedicoDTO obtenerMedico(int idMedico) throws Exception {

        Medico buscado = null;


        Optional<Medico> opcional = medicoRepo.findById(idMedico);

        if (opcional.isEmpty()) {


            throw new Exception("no existe médico con ese id");
        } else {

            buscado = opcional.get();

            List<DiaTrabajoMedico> horarios = buscado.getDiasTrabajo();
        }


        MedicoDTO  medicoDTO = new MedicoDTO(
                buscado.getNombre(), buscado.getCedula(), buscado.getCiudad(),buscado.getUrlFoto(),
                buscado.getEspecialidad(),buscado.getTelefono(),buscado.getEmail(),buscado.getPassword(), new ArrayList<>()
        );

        return medicoDTO;
    }

    @Override
    public List<PQRDTO> listarPQRS() {

        List<PQR> listaPqrs = pqrsRepo.findAll();

        List <PQRDTO> respuesta = new ArrayList<>();

        for (PQR p: listaPqrs){
            respuesta.add(new PQRDTO(

                    p.getEstado(),p.getDescripcion(),p.getFecha(),
                    p.getPaciente().getNombre(), p.getAdministrador().getCodigo()
                    , p.getMotivo()
            ));

        }
        return respuesta;
    }

    @Override
    public int responderPQRS(RespuestaDTO respuestaDTO, int idPqr) throws Exception {


        Optional <PQR> opcional = pqrsRepo.findById(idPqr);

        if (opcional.isEmpty()){

            throw new Exception("no hay pqr con esa id");
        }

        Respuesta respuesta = new Respuesta();

        respuesta.setPqr(opcional.get());
        respuesta.setFecha(LocalDateTime.now());
        respuesta.setDescripcion(respuestaDTO.descripcion());
        respuesta.setIdRespuesta(respuestaDTO.id());
        respuesta.setCuenta(opcional.get().getPaciente());


        opcional.get().getRespuestas().add(respuesta);
        respuestaRepo.save(respuesta);
        pqrsRepo.save(opcional.get());

        return respuesta.getIdRespuesta();
    }


    @Override
    public PQRDTO verDetallePQRS(int idPqr) throws Exception {


        Optional <PQR> opcional = pqrsRepo.findById(idPqr);

        if (opcional.isEmpty()){

            throw new Exception("no hay pqr con esa id");
        }

        PQR buscado = opcional.get();


        return new PQRDTO(

                buscado.getEstado(),buscado.getDescripcion(),buscado.getFecha(),
                buscado.getPaciente().getNombre(), buscado.getAdministrador().getCodigo()
                , buscado.getMotivo()
        );
    }

    @Override
    public void cambiarEstadoPqr(int codigoPqr, EstadoPqr estadoPqr) {

       Optional<PQR> pqr = pqrsRepo.findById(codigoPqr);

       PQR pqrActualizada = pqr.get();

       pqrActualizada.setEstado(estadoPqr);


       pqrsRepo.save(pqrActualizada);


    }

    @Override
    public List<CitaDTOAdmin> listarCitas() {


        List<Cita> citas = citaRepo.findAll();
        List<CitaDTOAdmin> respuesta = new ArrayList<>();

        for (Cita c : citas){

            respuesta.add(new CitaDTOAdmin(

                    c.getIdCita(),c.getPaciente().getNombre(),c.getMedico().getNombre()
                    ,c.getFechaCreacion(),c.getFechaCita(),c.getMotivo(),c.getPaciente().getCedula(),
                    c.getMedico().getCedula(), c.getPaciente().getCodigo(), c.getMedico().getCodigo(),c.getEstadoCita()

            ));

            }


        return respuesta;
    }




}
