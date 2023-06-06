package andres.java.Proyect.Repositorio;

import andres.java.Proyect.Modelo.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudRepository extends JpaRepository<Solicitud, Long> {
}

