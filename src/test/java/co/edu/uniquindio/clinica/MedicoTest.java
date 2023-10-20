package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.CitaDTOMedico;
import co.edu.uniquindio.clinica.dto.RecetaDTO;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MedicoTest {

    @Autowired
    private MedicoServicio medicoServicio;

   @Autowired
    private CitaServicio citaServicio;

@Test
@Sql("classpath:dataset.sql")
    public void filtrarCitasPendientesPorFecha () throws Exception {


    String fechaString = "2023-12-12";
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    Date fecha = (Date) formatoFecha.parse(fechaString);


    medicoServicio.filtrarCitasPendientesPorFecha(fecha);
}
    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPendientesPorCedulaPaciente() throws Exception {


    medicoServicio.filtrarCitasPendientesCedulaPaciente("123432");

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPendientesPorNombrePaciente() throws Exception {


        medicoServicio.filtrarCitasPendientesNombrePaciente("alexander");


    }


    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarHistorialMedicoPorId() throws Exception {


        medicoServicio.filtrarHistorialMedicoPorId("123432");


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPendientes() throws Exception {

        String fechaString = "2023-12-12";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);


        medicoServicio.filtrarHistorialMedicoPorFecha(fecha);


    }


    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarHistorial() throws Exception {
        String fechaString = "2023-12-12";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);
    medicoServicio.reservarDiaLibre(fecha);

    }






}
