package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
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
        medicoNuevo.setPassword(medicoDTO.password());
        medicoNuevo.setEmail(medicoDTO.correo());


        if (estaRepetidoCorreo(medicoDTO.correo())) {

            throw new Exception("El correo está repetido");

        }

        if (estaRepetidoCedula(medicoDTO.cedula())) {

            throw new Exception("la cedula está repetida");

        }
        Medico medicoRegistrado = medicoRepo.save(medicoNuevo);
        return medicoRegistrado.getCodigo();
    }


    private boolean estaRepetidoCorreo(String correo) {

        boolean esRepetido = medicoRepo.findByCorreo(correo);
        return esRepetido;
    }

    private boolean estaRepetidoCedula(String cedula) {


        boolean esRepetido = medicoRepo.findByCedula(cedula);
        return esRepetido;

    }

    @Override
    public int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception {

        Optional <Medico> opcional = medicoRepo.findById(codigoMedico);



        Medico medicoBuscado = new Medico();

        medicoBuscado.setCiudad(medicoDTO.ciudad());
        medicoBuscado.setNombre(medicoDTO.nombre());
        medicoBuscado.setCedula(medicoDTO.cedula());
        medicoBuscado.setTelefono(medicoDTO.telefono());
        medicoBuscado.setUrlFoto(medicoDTO.URL_foto());
        medicoBuscado.setEspecialidad(medicoDTO.especialidad());
        medicoBuscado.setEmail(medicoDTO.correo());

        if (estaRepetidoCorreo(medicoDTO.correo())) {

            throw new Exception("El correo está repetido");

        }

        if (estaRepetidoCedula(medicoDTO.cedula())) {

            throw new Exception("la cedula está repetida");

        }

        medicoRepo.save(medicoBuscado);

        return 0;

    }

    @Override
    public int eliminarMedico(int codigoMedico) throws Exception{


        Optional<Medico> opcional =medicoRepo.findById(codigoMedico);

       if (opcional.isEmpty()){


           throw new Exception("no existe médico con ese id");
       }else{

           Medico buscado = opcional.get();

           //medicoRepo.delete(buscado);  delete from medico where medigo.codigo =111
           buscado.setEstado(EstadoUsuario.ESTADO_INACTIVO);
       }
        return 0;

    }

    @Override
    public List<MedicoDTO> listarMedicos() {




        return null;
    }

    @Override
    public MedicoDTO obtenerMedico(int idMedico) throws Exception {

        Medico buscado = null;


        Optional<Medico> opcional = medicoRepo.findById(idMedico);

        if (opcional.isEmpty()) {


            throw new Exception("no existe médico con ese id");
        } else {

            buscado = opcional.get();
        }


        MedicoDTO  medicoDTO = new MedicoDTO(
                buscado.getNombre(), buscado.getCedula(), buscado.getCiudad(),buscado.getUrlFoto(),
                buscado.getEspecialidad(),buscado.getTelefono(),buscado.getEmail(),buscado.getPassword()
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
        respuesta.setCuenta(respuestaDTO.codigoCuenta());


        return 0;
    }


    @Override
    public PQRDTO verDetallePQRS(int idPqr) throws Exception {


        Optional <PQR> opcional = pqrsRepo.findById(idPqr);

        if (opcional.isEmpty()){

            throw new Exception("no hay pqr con esa id");
        }

        PQR buscado = opcional.get();


        return new PQRDTO (

                buscado.getEstado(),buscado.getDescripcion(),buscado.getFecha(),
                buscado.getPaciente().getNombre(), buscado.getAdministrador().getCodigo()
                , buscado.getMotivo()
        );
    }


}
