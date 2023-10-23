package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.ImagenDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.ImagenesServicio;
import jakarta.mail.Multipart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImagenesServicioImpl implements ImagenesServicio {

    @Override
    public Map<?,?> subirImagen(MultipartFile imagen) {
        return null;
    }

    @Override
    public Map<?, ?> eliminarImagen(int codigo) {
        return null;
    }

}
