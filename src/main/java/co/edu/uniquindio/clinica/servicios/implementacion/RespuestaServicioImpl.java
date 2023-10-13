package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.PQR;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.entidades.Respuesta;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.repositorios.RespuestaRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.RespuestaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RespuestaServicioImpl implements RespuestaServicio {

    private final RespuestaRepo respuestaRepo;

    private final PQRSRepo pqrsRepo;

    private final PqrServicio pqrServicio;

    private final PacienteServicio pacienteServicio;

    private final EmailServicio emailServicio;

    private final PacienteRepo pacienteRepo;



    @Override
    public int responderPqr(RespuestaDTO respuestaDto)throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(respuestaDto.codigoCuenta());

        PQR pqr = pqrsRepo.findPQRByIdPqr(respuestaDto.idPQR());

        if (pqr == null){
            throw new Exception ("No hay ninguna PQR con el codigo "+respuestaDto.idPQR());
        }

        Respuesta respuesta = new Respuesta();

        respuesta.setPqr(pqrServicio.obtenerPqr(respuestaDto.idPQR()));
        respuesta.setFecha(LocalDateTime.now());
        respuesta.setCuenta(pacienteServicio.obtenerPaciente(respuestaDto.codigoCuenta()));
        respuesta.setDescripcion(respuestaDto.descripcion());

        String email = "<h1>Respuesta A Su PQR</h1><h2><p> Estimado(a) " +opcional.get().getNombre() + " Su PQR ha sido respondida </p> </h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "Notificacion PQR",
                email,
                opcional.get().getEmail()));



        return respuestaRepo.save(respuesta).getIdRespuesta();
    }
}
