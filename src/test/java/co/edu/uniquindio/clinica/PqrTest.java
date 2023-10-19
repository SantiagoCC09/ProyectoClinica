package co.edu.uniquindio.clinica;


import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.PQRDTOPaciente;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import co.edu.uniquindio.clinica.servicios.implementacion.PqrServicioImpl;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
@Transactional
public class PqrTest {
    @Autowired
    PqrServicio pqrServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearPQR() throws Exception{

        String fechaString = "2023-10-19";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);
        PQRDTOPaciente pqrdtoPaciente = new PQRDTOPaciente(EstadoPqr.TRAMITADA, "Cancelar cita",
                fecha, LocalDateTime.now(), 1,"Calamidad domestica",5);

        pqrServicio.crearPqr(pqrdtoPaciente);
    }

}
