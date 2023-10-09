package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepo extends JpaRepository<Receta, Integer> {
}
