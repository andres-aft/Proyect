package andres.java.Proyect.Servicios;

import andres.java.Proyect.Modelo.Empleado;
import andres.java.Proyect.Repositorio.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> buscarEmpleado(Long ID) {
        return empleadoRepository.findById(ID);
    }

    @Override
    public Empleado guardarEmpleado(Empleado EMPLEADO) {
        return empleadoRepository.save(EMPLEADO);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado EMPLEADO) {
        return empleadoRepository.save(EMPLEADO);
    }

    @Override
    public void eliminarEmpleado(Long ID) {
        empleadoRepository.deleteById(ID);
    }
}
