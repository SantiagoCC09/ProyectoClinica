package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.ConsultaDTO;
import co.edu.uniquindio.clinica.entidades.Consulta;
import co.edu.uniquindio.clinica.servicios.interfaces.ConsultaServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ConsultaTest {
    @Autowired
    ConsultaServicio consultaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearConsulta() throws Exception{
        ConsultaDTO consultaDTO = new ConsultaDTO("Ingerir carbohidratos","Reducir azucar",
                "El paciente va a morir",1);
        int codigo = consultaServicio.crearConsulta(consultaDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConsulta() throws Exception{
        int codigoConsulta=2;
        consultaServicio.eliminarConsulta(codigoConsulta);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerConsulta() throws Exception{

        int codigoConsulta=2;
        Consulta consulta = consultaServicio.obtenerConsulta(codigoConsulta);
}
}
