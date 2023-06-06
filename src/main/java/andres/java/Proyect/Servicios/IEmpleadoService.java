package andres.java.Proyect.Servicios;

import andres.java.Proyect.Modelo.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    List<Empleado> listarEmpleados();
    Optional<Empleado> buscarEmpleado(Long ID);
    Empleado guardarEmpleado(Empleado EMPLEADO);
    Empleado actualizarEmpleado(Empleado EMPLEADO);
    void eliminarEmpleado(Long ID);
}
