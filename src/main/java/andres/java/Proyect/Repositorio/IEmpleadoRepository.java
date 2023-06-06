package andres.java.Proyect.Repositorio;

import andres.java.Proyect.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository <Empleado, Long> {
}
