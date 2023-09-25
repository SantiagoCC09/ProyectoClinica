package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final AdministradorRepo administradorRepo;

    private final EmailServicio emailServicio;


    @Override
    public int crearMedico(MedicoDTO medicoDTO) {


        return 0;
    }

    @Override
    public int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) {


        return 0;

    }

    @Override
    public int eliminarMedico( int codigoMedico) {

        return 0;

    }

    @Override
    public void listarMedicos() {

    }

    @Override
    public void obtenerMedico() {

    }

    @Override
    public void listarPQRS() {

    }

    @Override
    public void responderPQRS() {

    }

    @Override
    public void verDetallePQRS() {

    }
}
