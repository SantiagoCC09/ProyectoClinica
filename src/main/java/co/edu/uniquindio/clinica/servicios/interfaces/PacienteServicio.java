package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.dto.PacienteGetDTO;
import co.edu.uniquindio.clinica.entidades.Paciente;



public interface PacienteServicio {


    //funciones asociadas a la entidad, crear, actualizar, iniciar sesion, etc

    int crearPaciente(PacienteDTO pacienteDTO) throws Exception;

    int actualizarPaciente(int cedulaPaciente, PacienteDTO pacienteDTO) throws Exception;

    int eliminiarPaciente(int cedulaPaciente) throws Exception;

    Paciente obtenerPacienteU(int cedulaPaciente) throws Exception;

     PacienteGetDTO obtenerPaciente(int cedulaPaciente) throws Exception;
     void validarExiste(int cedulaPaciente) throws Exception;
}
