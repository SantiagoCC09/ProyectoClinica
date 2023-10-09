package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.entidades.Consulta;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepo extends JpaRepository <Consulta, Integer> {




}
