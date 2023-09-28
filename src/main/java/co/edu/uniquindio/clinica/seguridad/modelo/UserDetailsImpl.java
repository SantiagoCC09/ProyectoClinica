package co.edu.uniquindio.clinica.seguridad.modelo;


import co.edu.uniquindio.clinica.entidades.Administrador;
import co.edu.uniquindio.clinica.entidades.Cuenta;
import co.edu.uniquindio.clinica.entidades.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String username, password;
    private Collection<? extends GrantedAuthority> authorities;
    public static UserDetailsImpl build(Cuenta user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user instanceof Usuario){
            authorities.add( new SimpleGrantedAuthority("USUARIO") );
        }else if(user instanceof Administrador){
            authorities.add( new SimpleGrantedAuthority("ADMINISTRRADOR") );
        }
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
