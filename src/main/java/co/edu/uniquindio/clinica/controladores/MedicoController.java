package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoServicio medicoServicio;

    private final CitaServicio citaServicio;

    private final ConsultaServicio consultaServicio;

    @PostMapping("/crear-consulta")
    public ResponseEntity<MensajeDTO<String>> crearConsulta(@Valid @RequestBody ConsultaDTO consultaDTO) throws Exception{
        consultaServicio.crearConsulta(consultaDTO);

        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Consulta creada correctamente"));
    }

    @DeleteMapping("/eliminarConsulta/{codigoConsulta}")
    public ResponseEntity<MensajeDTO<String>> eliminarConsulta(@PathVariable int codigoConsulta) throws Exception {
        consultaServicio.eliminarConsulta(codigoConsulta);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Consulta eliminada correctamente"));
    }

    @GetMapping("/obtenerMedico/{idMedico}")
    public ResponseEntity<MensajeDTO<MedicoDTO>> obtenerMedico(@PathVariable int idMedico) throws Exception {

        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.obtenerMedicoDTO(idMedico)));
    }
    @GetMapping("/listarCitasPendientes-nombrePaciente/{nombrePaciente}/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> listarCitasPaciente(
            @PathVariable String nombrePaciente,
            @PathVariable int codigoMedico
    ) throws Exception {
        return ResponseEntity.ok().body(
                new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesNombrePaciente(nombrePaciente, codigoMedico))
        );
    }

    @GetMapping("/listarCitas-todas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> listarCitas(@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitas(codigoMedico)));
    }

    @GetMapping("/listarCitas-cedulaPaciente")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> filtrarCitasPendientesCedulaPaciente(
            @RequestParam int codigoMedico,
            @RequestParam String cedulaPaciente
    ) throws Exception {
        return ResponseEntity.ok().body(
                new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesCedulaPaciente(cedulaPaciente, codigoMedico))
        );
    }


    @GetMapping("/listarCitas-fecha")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> filtrarCitasPendientesPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @RequestParam int codigoMedico
    ) throws Exception {
        return ResponseEntity.ok().body(
                new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesPorFecha(date, codigoMedico))
        );
    }



    @PostMapping("/agendarDia-libre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody Date dia) throws Exception{
        medicoServicio.reservarDiaLibre(dia);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Dia libre agendado correctamente"));
    }



}
