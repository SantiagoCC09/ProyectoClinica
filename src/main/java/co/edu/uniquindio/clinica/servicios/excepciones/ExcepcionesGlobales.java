package co.edu.uniquindio.clinica.servicios.excepciones;
import co.edu.uniquindio.clinica.dto.ValidacionDTO;

import java.util.List;
import jakarta.validation.constraints.NotNull;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;


import java.util.ArrayList;

@RestControllerAdvice
public class ExcepcionesGlobales {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDTO<String>> generalException(Exception e){
        return ResponseEntity.internalServerError().body( new MensajeDTO<>(HttpStatus.OK,true, e.getMessage())
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDTO> validationException(MethodArgumentNotValidException ex){
        List<ValidacionDTO> errores = new ArrayList<>();
        BindingResult results = ex.getBindingResult();
        for (FieldError e: results.getFieldErrors()) {
            errores.add( new ValidacionDTO(e.getField(), e.getDefaultMessage()) );
        }
        return ResponseEntity.badRequest().body( new MensajeDTO<>(HttpStatus.OK,true, errores) );
    }
}