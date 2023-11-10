package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.dto.PasswordDTO;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.ReestablecerPasswordServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class ReestablecerPasswordServicioImpl implements ReestablecerPasswordServicio {

    private final PacienteRepo pacienteRepo;


    private final PasswordEncoder passwordEncoder;

    private final EmailServicio emailServicio;

    @Override
    public int cambiarConstrasenaAnterior(int idPerson, PasswordDTO passwordDTO) throws Exception {
        Paciente pacienteEncontrado = pacienteRepo.buscarPacienteCodigo(idPerson);

        if(pacienteEncontrado == null){
            throw new Exception("No se encontro una persona con el id " + idPerson);
        }
        String newPassword = passwordDTO.password();
        String newPasswordRepeated = passwordDTO.passwordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        pacienteEncontrado.setPassword(passwordEncoder.encode(newPassword));

        pacienteRepo.save(pacienteEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Se actualizó su contraseña", "Ha actualizado con exito la contraseña de su cuenta", pacienteEncontrado.getEmail()));

        return pacienteEncontrado.getCodigo();
    }

    @Override
    public void recuperarContrasena(String email) throws Exception {
        emailServicio.enviarEmail(new EmailDTO("Recuperar contraseña","Para recuperar su contraseña ingrese al siguiente enlace: https://www.clinicauq.com/api/pacientes/recuperar-contraseña/" + email,email));
    }

    @Override
    public String cambiarContrasenaRecuperada(String email, PasswordDTO passwordDTO) throws Exception {
        Paciente pacienteEncontrado = pacienteRepo.buscarPacienteEmail(email);

        if(pacienteEncontrado == null){
            throw new Exception("No se encontro una persona con el correo " + email);
        }

        String newPassword = passwordDTO.password();
        String newPasswordRepeated = passwordDTO.passwordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        pacienteEncontrado.setPassword(passwordEncoder.encode(newPassword));

        pacienteRepo.save(pacienteEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Contraseña Actualizada", "Se ha actualizado tu contraseña con exito", pacienteEncontrado.getEmail()));

        return pacienteEncontrado.getPassword();
    }

    private boolean validatePassword(String newPassword, String newPasswordRepeated) throws Exception {

        if(newPassword.equals(newPasswordRepeated) != true){
            throw new Exception("Las contraseñas no coinciden");
        }
        return true;
    }
}
