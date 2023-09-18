package co.edu.uniquindio.clinica.servicios.interfaces;


public interface MedicoServicio {

    public void verPerfil();

    public void filtrarCitasPendientesPorFecha();

    public void filtrarCitasPendientesNombreCliente();

    public void filtrarCitasPendientesIdCLiente();

    public void atenderCitaSeleccionada();

    public void filtrarDisponibilidadPorFecha();

    public void reservarDiaLibre();

    public void deshacerDiaLibre();

    public void filtrarHistorialMedicoPorFecha();

    public void filtrarHistorialMedicoPorId();


}
