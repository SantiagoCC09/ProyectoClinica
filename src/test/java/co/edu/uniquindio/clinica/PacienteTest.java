package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.*;
import co.edu.uniquindio.clinica.servicios.implementacion.PacienteServicioImpl;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest
@Transactional
public class PacienteTest {
    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
   @Sql("classpath:dataset.sql")
    public void crearPaciente() throws Exception{
        String fechaNacimientoString = "2002-09-09";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = (Date) formatoFecha.parse(fechaNacimientoString);
        PacienteDTO paciente = new PacienteDTO(
                "12345", "juan-felipe-00@hotmail.com","password",
                "Juan Felipe Chavarria Vidal", "3165308765", Ciudad.Armenia,
                fechaNacimiento,TipoSangre.APOSTIVIO, EPS.EMSSANAR,"mifoto","alergia a los perros"
        );

        pacienteServicio.registrarse(paciente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuenta() throws Exception{
        int codigoEliminar=4;
        pacienteServicio.eliminarCuenta(codigoEliminar);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarPerfil() throws Exception{
        int codigoPaciente=5;

        String fechaNacimientoString = "2002-09-09";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = (Date) formatoFecha.parse(fechaNacimientoString);
        PacienteDTO pacienteDTO = new PacienteDTO("5","santi@gmail.com", "passwd","Santiago CC","31666",
                Ciudad.Armenia,fechaNacimiento,TipoSangre.APOSTIVIO,EPS.EMSSANAR,"urlFoto","alergia a los perros");
        pacienteServicio.editarPerfil(pacienteDTO, codigoPaciente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPaciente() throws Exception{
        int codigoPaciente=5;
        Paciente paciente = pacienteServicio.obtenerPaciente(codigoPaciente);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleCita ()throws Exception{

        int idCita=1;

        InfoCitaDTO infoCitaDTO = pacienteServicio.verDetalleCita(idCita);

        System.out.println(infoCitaDTO);


    }
}
