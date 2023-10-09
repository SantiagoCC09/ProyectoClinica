package co.edu.uniquindio.clinica.seguridad.servicios;

import co.edu.uniquindio.clinica.entidades.Administrador;
import co.edu.uniquindio.clinica.entidades.Paciente;
import co.edu.uniquindio.clinica.entidades.Usuario;
import co.edu.uniquindio.clinica.repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;

import co.edu.uniquindio.clinica.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PacienteRepo pacienteRepo;
    @Autowired
    private AdministradorRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Paciente> paciente = pacienteRepo.findByEmail(email);
        if(paciente.isEmpty()){
            Optional<Administrador> admin = adminRepo.findByEmail(email);
            if(admin.isEmpty())
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin.get());
        }else{
            return UserDetailsImpl.build(paciente.get());
        }
    }
}