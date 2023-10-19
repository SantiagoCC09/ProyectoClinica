package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
public class CitaTest {


    @Autowired
   private CitaServicio citaServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCitaTest() throws Exception {

        String fechaCitaString = "2023-10-15 08:00:00";
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaCita = LocalDateTime.parse(fechaCitaString, formatoFecha);

        CitaDTOAdmin cita = new CitaDTOAdmin(1,"alexander",
        "carlos", LocalDateTime.now(),fechaCita,"Medicina General","123432","123"
                ,6,3);



        int nuevo = citaServicio.crearCita(cita);

        Assertions.assertNotEquals(0,nuevo);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPaciente() throws Exception{
        int codigoPaciente =4;

        citaServicio.listarCitasPaciente(codigoPaciente);

        List<InfoCitaDTO> lista = citaServicio.listarCitasPaciente(codigoPaciente);
        System.out.println(lista);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPorFecha() throws Exception{

        int codigoPaciente =4;

        String fechaCitaString = "2023-10-10";
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaCita = LocalDateTime.parse(fechaCitaString, formatoFecha);

        citaServicio.filtrarCitasPorFecha(codigoPaciente, fechaCita);

    }





}


