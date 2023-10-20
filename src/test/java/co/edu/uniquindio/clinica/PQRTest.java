package co.edu.uniquindio.clinica;


import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.dto.PQRDTOPaciente;
import co.edu.uniquindio.clinica.entidades.EstadoPqr;
import co.edu.uniquindio.clinica.servicios.interfaces.PqrServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPQR() throws Exception{
        int idPQR=1;

        String fechaString = "2023-10-19";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = (Date) formatoFecha.parse(fechaString);
        PQRDTOPaciente pqrdtoPaciente = new PQRDTOPaciente(EstadoPqr.TRAMITADA, "Aplazar cita",
                fecha, LocalDateTime.now(), 1,"Calamidad domestica",5);

        pqrServicio.actualizarPqr(pqrdtoPaciente, idPQR);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPQR() throws Exception{
        int idPQR=1;
        pqrServicio.eliminarPqr(idPQR);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPQR() throws Exception{
        int idPQR=1;
        pqrServicio.obtenerPqr(idPQR);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPaciente() throws Exception{

        int codigoPaciente=4;
        List<PQRDTO> lista = pqrServicio.listarPQRSPaciente(codigoPaciente);

        System.out.println(lista);
        System.out.println("");
    }



}
