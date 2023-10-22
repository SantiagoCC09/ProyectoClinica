package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.SesionDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.AutenticacionServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {
    private final AutenticacionServicio autenticacionServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody SesionDTO sesionDTO)
            throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.login(sesionDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(HttpStatus.OK,false, tokenDTO));
    }
}