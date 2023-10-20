package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.InfoCitaDTO;
import co.edu.uniquindio.clinica.entidades.EstadoCita;
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

        String fechaString = "2023-10-19";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);

        CitaDTOAdmin cita = new CitaDTOAdmin(1,"alexander",
        "carlos", LocalDateTime.now(),fecha,"Medicina General","123432","123"
                ,6,3, EstadoCita.Completada);



        int nuevo = citaServicio.crearCita(cita);

        Assertions.assertNotEquals(0,nuevo);




    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPaciente() throws Exception{
        int codigoPaciente =4;
        List<InfoCitaDTO> lista = citaServicio.listarCitasPaciente(codigoPaciente);
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCita() throws Exception{

        String fechaString = "2023-10-19";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);
        int codigoCita=1;
        CitaDTOAdmin citaDTOAdmin = new CitaDTOAdmin(codigoCita,"Carlos","Julian",LocalDateTime.now(),fecha,"Aplazar",
                "4","3",4,3,EstadoCita.Completada);
        citaServicio.actualizarCita(citaDTOAdmin, codigoCita);
    }


}


