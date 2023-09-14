package co.edu.uniquindio.clinica.servicios.excepciones;


import co.edu.uniquindio.clinica.repositorios.PacienteRepo;

public class AttributeException extends Exception {

    private PacienteRepo pacienteRepo;
    public AttributeException(String mensaje) {
        super(mensaje);
    }

}