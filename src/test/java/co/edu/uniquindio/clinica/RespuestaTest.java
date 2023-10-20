package co.edu.uniquindio.clinica;
import co.edu.uniquindio.clinica.dto.RespuestaDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.RespuestaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class RespuestaTest {

    @Autowired
    RespuestaServicio respuestaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPqr() throws Exception{

        List<RespuestaDTO> listaRespuestasDto = new ArrayList<>();
        respuestaServicio.responderPqr(new RespuestaDTO(

                2,"descReceta", LocalDateTime.now(),5,1,listaRespuestasDto

        ));


    }
}
