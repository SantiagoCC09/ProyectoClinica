package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.entidades.Ciudad;
import co.edu.uniquindio.clinica.entidades.Especialidad;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class AdministradorTest {


    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    public void crearMedicoTest () throws Exception {

        MedicoDTO medico = new MedicoDTO(

                "juan","2324", Ciudad.Armenia,"foto", Especialidad.PEDIATRIA,
                "12345","@gmali","asd"

        );


        administradorServicio.crearMedico(medico);

    }


}
