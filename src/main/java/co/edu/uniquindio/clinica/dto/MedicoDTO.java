package co.edu.uniquindio.clinica.dto;

import java.util.List;

public record MedicoDTO(
    String nombre,
    String cedula,
    int codigoCiudad, String URL_foto,
    int codigoEspecialidad,
    String telefono,
    String correo,
    String password,
    List< DiaTrabajoMedicoDTO > horarios

){
}
