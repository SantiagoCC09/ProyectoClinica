package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
<<<<<<< HEAD
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Paciente;
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
    public int registrarse(@Valid @RequestBody PacienteDTO pacienteDTO) throws Exception{
        return pacienteServicio.registrarse(pacienteDTO);
    }

    @PutMapping("/editar-perfil")
    public int editarPerfil(@Valid @RequestBody PacienteDTO pacienteDTO, int codigoPaciente) throws Exception{
        return pacienteServicio.editarPerfil(pacienteDTO,codigoPaciente);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCuenta(@PathVariable int codigo) throws Exception{
        pacienteServicio.eliminarCuenta(codigo);
    }

    @GetMapping("/ver-cita")
    public InfoCitaDTO verDetalleCita(@Valid @RequestBody int idCita)throws Exception{
       return pacienteServicio.verDetalleCita(idCita);

    }

=======
import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody PacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.registrarse(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(HttpStatus.OK,false, "Paciente registrado correctamente") );
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody PacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO, Integer.parseInt(pacienteDTO.cedulaPaciente()));
        return ResponseEntity.ok().body( new MensajeDTO<>(HttpStatus.OK,false, "Paciente actualizado correctamete") );
    }
    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigoPaciente) {
        try {
            pacienteServicio.eliminarCuenta(codigoPaciente);
            return ResponseEntity.ok().body(new MensajeDTO<>(HttpStatus.OK, false, "Paciente eliminado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeDTO<>(HttpStatus.BAD_REQUEST, true, e.getMessage()));
        }
    }
    @GetMapping("/detalle/{codigo}")
    public PacienteDTO verDetallePaciente(@PathVariable int codigo) throws Exception{
        return null;
    }
    @GetMapping("/listar-todos")
    public ResponseEntity<MensajeDTO<List<InfoCitaDTO>>> listarTodos(){
        return null;
    }
>>>>>>> 756ffb4e0e4b19ab18af3320d2794998250cb291

}
