package co.edu.uniquindio.clinica.servicios.implementacion;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.repositorios.PQRSRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PqrServicioImpl implements PqrServicio {

    private final AdministradorRepo administradorRepo;

    private final PacienteServicio pacienteServicio;

    private final PacienteRepo pacienteRepo;

    private final PQRSRepo pqrsRepo;

    private final EmailServicio emailServicio;


    @Override
    public int crearPqr(PQRDTOPaciente pqrDto) throws Exception {
        Optional<Administrador> opcionalAdmin = administradorRepo.findById(pqrDto.codigoAdministrador());

        Optional<Paciente> opcionalPaciente = Optional.ofNullable(pacienteServicio.obtenerPaciente(pqrDto.codigoPaciente()));


        PQR pqr = new PQR();

        pqr.setFecha(pqrDto.fecha());
        pqr.setDescripcion(pqrDto.descripcion());
        pqr.setMotivo(pqrDto.motivo());
        pqr.setEstado(EstadoPqr.RADICADA);

        pqr.setFechaCreacion(pqrDto.fechaCreacion());
        pqr.setAdministrador(opcionalAdmin.get());
        pqr.setPaciente(opcionalPaciente.get());

        PQR pqrGuardada = this.pqrsRepo.save(pqr);

        String email = "<h1>Nueva PQR Radicada</h1><h2><p> Señor Administrador(a) se ha radicado una nueva PQR </p> </h2>";

        emailServicio.enviarEmail(new EmailDTO(
                "Notificacion PQR",
                email,
                opcionalAdmin.get().getEmail()));


        return pqrGuardada.getIdPqr();
    }



    @Override
    public PQR obtenerPqr(int idPqr) throws Exception {

        Optional<PQR> pqr = pqrsRepo.findById(idPqr);

        if (pqr.isEmpty()) {
            throw new Exception("El código " + idPqr + " no está asociado a ningun pqr");
        }else{
            System.out.println("Sí hay pqr asociado");
        }

        return pqr.get();

    }

    @Override
    public List<PQRDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {

        List<PQR> lista = pqrsRepo.listarPQRSPorPaciente(codigoPaciente);

        if (lista.isEmpty()) {

            throw new Exception("el paciente " + codigoPaciente + " no tiene asociado ningun pqr");
        }

        List<PQRDTO> respuesta = new ArrayList<>();

        for (PQR pqr : lista) {

            respuesta.add(convertir(pqr));
        }
        return respuesta;
    }

    private PQRDTO convertir(PQR pqr) {
        PQRDTO pqrGetDTO = new PQRDTO(
                pqr.getEstado(),
                pqr.getDescripcion(),
                pqr.getFecha(),
                pqr.getPaciente().getNombre(),
                pqr.getAdministrador().getCodigo(),
                pqr.getMotivo()
        );
        return pqrGetDTO;
    }

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
        } else {

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

}
