package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.EPS;
import co.edu.uniquindio.clinica.entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
   public void crearPaciente() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;

        try {
            java.util.Date utilDate = sdf.parse("2003-02-28");
            fechaNacimiento = new Date(utilDate.getTime());
        } catch (ParseException e) {
            // Manejar una excepción si la cadena de fecha no es válida
            e.printStackTrace();
        }


        PacienteDTO paciente = new PacienteDTO( "1001653268","juanf.chavarriav@uqvirtual.edu.co","12"
                ,"Juan Chavarria", "312232", Ciudad.Armenia,fechaNacimiento, TipoSangre.APOSTIVIO
                , EPS.SURA,"foto"

        );

        pacienteServicio.registrarse(paciente);


    }





}
