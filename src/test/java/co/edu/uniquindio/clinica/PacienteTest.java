package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.implementacion.PacienteServicioImpl;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import co.edu.uniquindio.clinica.entidades.EPS;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Transactional

public class PacienteTest {
    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearPaciente() throws Exception{
        String fechaNacimientoString = "2002-09-09";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = (Date) formatoFecha.parse(fechaNacimientoString);
        PacienteDTO paciente = new PacienteDTO(
                "12345", "alf@gmail.com","password",
                "Alf", "3165308765", Ciudad.Armenia,
                fechaNacimiento,TipoSangre.APOSTIVIO, EPS.EMSSANAR,"mifoto"
        );

        pacienteServicio.registrarse(paciente);
    }

    @Test
    public void eliminarCuenta() throws Exception{
        int codigoEliminar=4;
        pacienteServicio.eliminarCuenta(codigoEliminar);
    }
}
