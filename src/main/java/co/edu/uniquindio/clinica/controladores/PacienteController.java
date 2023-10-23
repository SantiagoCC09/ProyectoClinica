package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {


    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrarse")
    public int registrarse(@Valid @RequestBody PacienteDTO pacienteDTO) throws Exception {
        return pacienteServicio.registrarse(pacienteDTO);
    }

    @PutMapping("/editar-perfil")
    public int editarPerfil(@Valid @RequestBody PacienteDTO pacienteDTO, int codigoPaciente) throws Exception {
        return pacienteServicio.editarPerfil(pacienteDTO, codigoPaciente);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCuenta(@PathVariable int codigo) throws Exception {
        pacienteServicio.eliminarCuenta(codigo);
    }

    @GetMapping("/ver-cita")
    public InfoCitaDTO verDetalleCita(@Valid @RequestBody int idCita) throws Exception {
        return pacienteServicio.verDetalleCita(idCita);

    }

}