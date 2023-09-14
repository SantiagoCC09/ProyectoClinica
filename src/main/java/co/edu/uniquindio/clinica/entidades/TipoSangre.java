package co.edu.uniquindio.clinica.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;


public enum TipoSangre  {

    APOSTIVIO,ANEGATIVO, ABPOSITIVO, ABNEGATIVO, OPOSITIVO, ONEGATIVO;

}
