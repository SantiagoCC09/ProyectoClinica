package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ReestablecerPasswordServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {


    private final PacienteServicio pacienteServicio;

    private final CitaServicio citaServicio;

    private final PqrServicio pqrServicio;

    private final ReestablecerPasswordServicio reestablecerPasswordServicio;

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody PacienteDTO pacienteDTO, int codigoPaciente) throws Exception {
        pacienteServicio.editarPerfil(pacienteDTO, codigoPaciente);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado correctamente") );
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception {
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamente")
        );
    }

    @GetMapping("/ver-cita")
    public ResponseEntity<MensajeDTO<String>> verDetalleCita(@Valid @RequestBody int idCita) throws Exception {
         pacienteServicio.verDetalleCita(idCita);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Detalle de cita generado correctamente"));
    }

    @PostMapping("/crear-cita")
    public ResponseEntity<MensajeDTO<String>> crearCita(@Valid @RequestBody CitaDTOAdmin citaDTOAdmin) throws Exception{
        citaServicio.crearCita(citaDTOAdmin);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cita programada correctamente"));
    }

    @PutMapping("/actualizar-cita")
    public ResponseEntity<MensajeDTO<String>> actualizarCita(@Valid @RequestBody CitaDTOAdmin citaDTOAdmin, int codigoCita) throws Exception {
        citaServicio.actualizarCita(citaDTOAdmin, codigoCita);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cita actualizada correctamente"));
    }

    @DeleteMapping("/eliminarCita/{codigoCita}")
    public ResponseEntity<MensajeDTO<String>> eliminarCita(@PathVariable int codigoCita) throws Exception {
        citaServicio.eliminarCita(codigoCita);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cita cancelada correctamente"));
    }


    @GetMapping("/listarCitas-todas")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> listarCitasPaciente(int codigoPaciente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, citaServicio.listarCitasPaciente(codigoPaciente)));
    }

    @GetMapping("/listarCitas-fecha")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorFecha(int codigoPaciente, LocalDateTime fecha) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, citaServicio.filtrarCitasPorFecha(codigoPaciente,fecha)));
    }

    @GetMapping("/listarCitas-medico")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> filtrarCitasPorMedico(int codigoPaciente, int codigoMedico) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, citaServicio.filtrarCitasPorMedico(codigoPaciente,codigoMedico)));
    }

    @PostMapping("/crear-pqr")
    public ResponseEntity<MensajeDTO<String>> crearPqr(@Valid @RequestBody PQRDTOPaciente pqrdtoPaciente) throws Exception{
        pqrServicio.crearPqr(pqrdtoPaciente);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "PQRS creado correctamente"));
    }

    @GetMapping("/obtener-pqrs")
    public ResponseEntity<MensajeDTO<String>> obtenerPQRS(@Valid @RequestBody int idPqr) throws Exception {
        pqrServicio.obtenerPqr(idPqr);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "PQRS obtenida correctamente"));
    }

    @GetMapping("/listarPqrs-paciente")
    public ResponseEntity<MensajeDTO<List<PQRDTO>>> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pqrServicio.listarPQRSPaciente(codigoPaciente)));
    }

    @PutMapping("/cambiarContraseniaAnterior/{idPerson}")
    public ResponseEntity<MensajeDTO<String>> cambiarConstrasenaAnterior(@PathVariable int idPerson, @Valid @RequestBody PasswordDTO passwordDTO) throws Exception{
       reestablecerPasswordServicio.cambiarConstrasenaAnterior(idPerson,passwordDTO);
         return ResponseEntity.ok().body( new MensajeDTO<>(false, "Contraseña Actualizada correctamente"));
    }
    @PutMapping("/cambiarContrasenaRecuperada/{emailPerson}")
    public ResponseEntity<MensajeDTO<String>> cambiarContrasenaRecuperada(@PathVariable String emailPerson,@Valid @RequestBody PasswordDTO passwordDTO) throws Exception{
        reestablecerPasswordServicio.cambiarContrasenaRecuperada(emailPerson,passwordDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Contraseña Cambiada correctamente"));
    }
    @PostMapping("/recuperarContrasena/{email}")
    public ResponseEntity<MensajeDTO<String>> recuperarContrasena(@PathVariable String email) throws Exception {
        reestablecerPasswordServicio.recuperarContrasena(email);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Correo Enviado correctamente"));
    }










}