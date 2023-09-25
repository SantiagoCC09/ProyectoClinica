package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import co.edu.uniquindio.clinica.entidades.Medico;
import co.edu.uniquindio.clinica.entidades.PQR;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {


    private final MedicoRepo medicoRepo;

    private final AdministradorRepo administradorRepo;

    private final EmailServicio emailServicio;


    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {

    Medico medicoNuevo = new Medico();

    medicoNuevo.setCiudad(Ciudad.values()[medicoDTO.codigoCiudad()]);
    medicoNuevo.setNombre(medicoDTO.nombre());
    medicoNuevo.setCedula(medicoDTO.cedula());
    medicoNuevo.setTelefono(medicoDTO.telefono());
    medicoNuevo.setUrlFoto(medicoDTO.URL_foto());
    medicoNuevo.setEspecialidad(Especialidad.values()[medicoDTO.codigoEspecialidad()]);


    medicoNuevo.setPassword(medicoDTO.password());
    medicoNuevo.setEmail(medicoDTO.correo());


    if (estaRepetidoCorreo(medicoDTO.correo()) ){

        throw new Exception("El correo está repetido");

        }

    if (estaRepetidoCedula(medicoDTO.cedula())){

        throw new Exception("la cedula está repetida");

    }
        Medico medicoRegistrado = medicoRepo.save(medicoNuevo);
        return medicoRegistrado.getCodigo();
    }

    private boolean estaRepetidoCorreo(String correo) {

        boolean esRepetido = medicoRepo.buscarEstaCorreo (correo);
        return esRepetido;
    }

    private boolean estaRepetidoCedula(String cedula) {


        boolean esRepetido = medicoRepo.buscarEstaCedula(cedula);
        return esRepetido;

    }

    @Override
    public int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) {


        return 0;

    }

    @Override
    public int eliminarMedico( int codigoMedico) {

        return 0;

    }

    @Override
    public List<Medico> listarMedicos() {
        return null;
    }

    @Override
    public Medico obtenerMedico(int idMedico) {
        return null;
    }

    @Override
    public List<PQR> listarPQRS() {
        return null;
    }

    @Override
    public int responderPQRS(RespuestaDTO respuestaDTO, int idPqr) {
        return 0;
    }


    @Override
    public String verDetallePQRS(int idPqr) {
        return null;
    }


}
