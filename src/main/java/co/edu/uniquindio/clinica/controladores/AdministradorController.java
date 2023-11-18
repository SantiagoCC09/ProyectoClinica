package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.RespuestaServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administrador")
public class AdministradorController {

    private final AdministradorServicio administradorServicio;



    @PostMapping("/crear-medico")
    public ResponseEntity<MensajeDTO<String>>  crearMedico(@Valid @RequestBody MedicoDTO medicoDTO) throws Exception {
        administradorServicio.crearMedico(medicoDTO);
          return ResponseEntity.ok().body( new MensajeDTO<>(false, "Medico creado correctamente"));
    }

    @PutMapping("/actualizar-medico")
    public ResponseEntity<MensajeDTO<String>> actualizarMedico(@Valid @RequestBody MedicoDTO medicoDTO, int codigoMedico) throws Exception {

         administradorServicio.actualizarMedico(codigoMedico, medicoDTO);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Medico actualizado"));

    }

    @DeleteMapping("/eliminarMedico/{codigoMedico}")
    public ResponseEntity<MensajeDTO<String>> eliminarMedico(@PathVariable  int codigoMedico) throws Exception {
        administradorServicio.eliminarMedico(codigoMedico);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Medico eliminado correctamente")
        );
    }

    @GetMapping("/listar-medicos")
    public ResponseEntity<MensajeDTO<List<MedicoDTO>>> listarMedicos() throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarMedicos()));
    }

    @GetMapping("/listar-pqrs")
    public ResponseEntity<MensajeDTO<List<PQRDTO>>>  listarPQRS(){

        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarPQRS()));
    }

    @PostMapping("/responder-pqrs/{idPqr}")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RespuestaDTO respuestaDTO,@PathVariable  int idPqr) throws Exception {

         administradorServicio.responderPQRS(respuestaDTO,idPqr);

         return ResponseEntity.ok().body( new MensajeDTO<>(false, "Respuesta generada correctamente"));
    }

    @GetMapping("/verDetalle-pqrs/{idPqr}")
    public ResponseEntity<MensajeDTO<String>> verDetallePQRS(@Valid @RequestBody @PathVariable  int idPqr) throws Exception {

         administradorServicio.verDetallePQRS(idPqr);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Detalle de pqr generado correctamente"));
    }

    @PutMapping("/camiarEstado-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPqr(@Valid @RequestBody  @PathVariable  int codigoPqr, EstadoPqr estadoPqr) throws Exception{

         administradorServicio.cambiarEstadoPqr(codigoPqr,estadoPqr);

         return ResponseEntity.ok().body( new MensajeDTO<>(false, "Estado de pqr cambiado correctamente"));
    }

    @GetMapping("/listar-citas")
    public ResponseEntity<MensajeDTO<List<CitaDTOAdmin>>> listarCitas(){

        return ResponseEntity.ok().body( new MensajeDTO<>(false, administradorServicio.listarCitas()));

    }



}
