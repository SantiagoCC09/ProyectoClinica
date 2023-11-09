package co.edu.uniquindio.clinica.controladores;


import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaServicio citaServicio;

    @PostMapping("/crear-cita")
    public int crearCita(@Valid @RequestBody CitaDTOAdmin citaDTOAdmin) throws Exception{

        return citaServicio.crearCita(citaDTOAdmin);

    }

    @GetMapping("/obtener-cita")
    public Cita obtenerCita(@Valid @RequestBody int codigoCita) throws Exception{
        return citaServicio.obtenerCita(codigoCita);
    }
    @PutMapping("/actualizar-cita")
    public int actualizarCita(@Valid @RequestBody CitaDTOAdmin citaDTOAdmin, int codigoCita) throws Exception{
        return citaServicio.actualizarCita(citaDTOAdmin,codigoCita);
    }

    @DeleteMapping("/eliminar-cita/{codigoCita}")
    public void eliminarCita(@Valid @RequestBody int codigoCita) throws Exception{
        citaServicio.eliminarCita(codigoCita);
    }




}
