package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administrador")
public class AdministradorController {

    private final AdministradorServicio administradorServicio;


    @PostMapping("/crear-medico")
    public int crearMedico(@Valid @RequestBody MedicoDTO medicoDTO) throws Exception {

        return administradorServicio.crearMedico(medicoDTO);
    }

    @PutMapping("/actualizar-medico")
    public int actualizarMedico(@Valid @RequestBody MedicoDTO medicoDTO, int codigoMedico) throws Exception {

        return administradorServicio.actualizarMedico(codigoMedico, medicoDTO);
    }

    @DeleteMapping("/eliminarMedico/{codigoMedico}")
    public void eliminarMedico(@Valid @RequestBody int codigoMedico) throws Exception {
        administradorServicio.eliminarMedico(codigoMedico);
    }

    @GetMapping("/listar-medicos")
    public List<MedicoDTO> listarMedicos() throws Exception{
        return administradorServicio.listarMedicos();
    }

    @GetMapping("/listar-pqrs")
    public List<PQRDTO> listarPQRS(){
        return administradorServicio.listarPQRS();
    }

    @PostMapping("/responder-pqrs/{idPqr}")
    public int responderPQRS(@Valid @RequestBody RespuestaDTO respuestaDTO, int idPqr) throws Exception {

        return administradorServicio.responderPQRS(respuestaDTO,idPqr);
    }

    @GetMapping("/verDetalle-pqrs/{idPqr}")
    public PQRDTO verDetallePQRS(@Valid @RequestBody int idPqr) throws Exception {

        return administradorServicio.verDetallePQRS(idPqr);
    }

    @PutMapping("/camiarEstado-pqrs/{codigo}")
    public void cambiarEstadoPqr(@Valid @RequestBody int codigoPqr, EstadoPqr estadoPqr) throws Exception{

         administradorServicio.cambiarEstadoPqr(codigoPqr,estadoPqr);

    }

    @GetMapping("/listar-citas")
    public List<CitaDTOAdmin> listarCitas(){

        return administradorServicio.listarCitas();
    }



}
