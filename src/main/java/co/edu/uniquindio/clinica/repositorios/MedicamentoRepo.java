package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepo extends JpaRepository <Medicamento,Integer> {
}
