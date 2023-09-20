package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.PQRDTO;
import co.edu.uniquindio.clinica.entidades.PQR;

public interface PqrServicio {



    public int crearPqr(PQRDTO pqrDto) throws Exception;
    public void actualizarPqr(PQRDTO pqrDto, int idPqr) throws Exception;
    public void eliminarPqr(int idPqr) throws Exception;
    public PQR obtenerPqr(int idPqr) throws Exception;


    
}
