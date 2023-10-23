package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.ImagenDTO;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.Map;

public interface ImagenesServicio {
    Map subirImagen(MultipartFile imagen);
    Map eliminarImagen(int codigo);
}
