package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/obtenerMedico")
    public ResponseEntity<MensajeDTO<String>> obtenerMedico(@Valid @RequestBody int idMedico) throws Exception {
        medicoServicio.obtenerMedico(idMedico);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Medico obtenido correctamente"));
    }

    @GetMapping("/listarCitasPendientes-nombrePaciente")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> listarCitasPaciente(String nombrePaciente,int codigoMedico) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesNombrePaciente(nombrePaciente,codigoMedico)));
    }

    @GetMapping("/listarCitas-todas")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> listarCitas(int codigoMedico) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.listarCitas(codigoMedico)));
    }

    @GetMapping("/listarCitas-cedulaPaciente")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> filtrarCitasPendientesCedulaPaciente(int codigoMedico, String cedulaPaciente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesCedulaPaciente(cedulaPaciente,codigoMedico)));

    }

    @GetMapping("/listarCitas-fecha")
    public ResponseEntity<MensajeDTO<List<CitaDTOMedico>>> filtrarCitasPendientesPorFecha(Date date, int codigoMedico) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicoServicio.filtrarCitasPendientesPorFecha(date,codigoMedico)));
    }








}
