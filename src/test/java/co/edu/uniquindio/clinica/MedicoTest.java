package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.CitaDTOMedico;
import co.edu.uniquindio.clinica.entidades.Cita;
import co.edu.uniquindio.clinica.servicios.interfaces.CitaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MedicoTest {

    @Autowired
    private MedicoServicio medicoServicio;

   @Autowired
    private CitaServicio citaServicio;

@Test
    public void filtrarCitasPendientesPorFecha () throws Exception {


    LocalDateTime date = LocalDateTime.now();




    medicoServicio.filtrarCitasPendientesPorFecha(date);


}


}
