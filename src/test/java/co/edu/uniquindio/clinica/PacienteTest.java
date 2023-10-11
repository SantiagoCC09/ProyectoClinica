package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.implementacion.PacienteServicioImpl;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class PacienteTest {
    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearPaciente() throws Exception{
        String fechaNacimientoString = "2002-09-09";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = (Date) formatoFecha.parse(fechaNacimientoString);
        PacienteDTO paciente = new PacienteDTO(
                "12345", "santiago31800@hotmail.com","password",
                "Santiago C", "3165308765", Ciudad.Armenia,
                fechaNacimiento,"",TipoSangre.APOSTIVIO
        );

        pacienteServicio.registrarse(paciente);
    }
}
