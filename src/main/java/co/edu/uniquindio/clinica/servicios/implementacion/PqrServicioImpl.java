package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.PQRDTOPaciente;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.Administrador;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import co.edu.uniquindio.clinica.entidades.PQR;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class PqrServicioImpl implements PqrServicio {
    private final PQRSRepo pqrsRepo;

    private final AdministradorRepo administradorRepo;
    private final PacienteRepo pacienteRepo;

    @Override
    public int responderPqr(RespuestaDTO respuestaDto) {
        return 0;
    }

    @Override
    public int crearPqr(PQRDTOPaciente pqrDto) throws Exception {
        Optional<Administrador> opcionalAdmin = administradorRepo.findById(pqrDto.codigoAdministrador());
        Optional<Paciente> opcionalPaciente = pacienteRepo.findById(pqrDto.codigoPaciente());


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
    public int actualizarPqr(PQRDTOPaciente pqrDto, int idPqr) throws Exception {
        Optional<PQR> opcionalPqr = pqrsRepo.findById(idPqr);


        PQR pqr = opcionalPqr.get();

        if (pqr != null) {

            Optional<Administrador> opcionalAdmin = administradorRepo.findById(pqrDto.codigoAdministrador());
            Optional<Paciente> opcionalPaciente = pacienteRepo.findById(pqrDto.codigoPaciente());

            pqr.setFecha(pqrDto.fecha());
            pqr.setDescripcion(pqrDto.descripcion());
            pqr.setMotivo(pqrDto.motivo());
            pqr.setEstado(pqrDto.estado());
            pqr.setFechaCreacion(pqrDto.fechaCreacion());
            pqr.setAdministrador(opcionalAdmin.get());
            pqr.setPaciente(opcionalPaciente.get());
        }else {

            throw new Exception("no se pudo actualizar la pqr porque no se encontró en el repo");
        }

        return pqrsRepo.save(pqr).getIdPqr();
    }



    @Override
    public int eliminarPqr(int idPqr) throws Exception {

        Optional<PQR> opcionalPqr = pqrsRepo.findById(idPqr);


        PQR pqr = opcionalPqr.get();

        if(pqr == null){


            throw new Exception("La pqr ya estaba nula o no se encontró en el repo... No se puede eliminar");
        }else{

            pqr.setEstado(EstadoPqr.ELIMINADA);


        }


        return pqrsRepo.save(pqr).getIdPqr();


    }



    @Override
    public PQR obtenerPqr(int idPqr) throws Exception {


       return null;
    }
}
