package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.EPS;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clinicauq")
@RequiredArgsConstructor
public class ClinicaController {

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO<List<String>>> obtenerCiudades() {
        List<String> ciudades = Arrays.stream(Ciudad.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new MensajeDTO<>(false, ciudades));
    }

    @GetMapping("/lista-especialidades")
    public ResponseEntity<MensajeDTO<List<String>>> obtenerEspecialidades() {
        List<String> especialidades = Arrays.stream(Especialidad.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new MensajeDTO<>(false, especialidades));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<String>>> obtenerTipoSangre() {
        List<String> tipoSangre = Arrays.stream(TipoSangre.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tipoSangre));
    }

    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO<List<String>>> obtenerEPS() {
        List<String> eps = Arrays.stream(EPS.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new MensajeDTO<>(false, eps));
    }




}
