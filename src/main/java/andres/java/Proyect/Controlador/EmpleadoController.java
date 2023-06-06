package andres.java.Proyect.Controlador;

import andres.java.Proyect.Modelo.Empleado;
import andres.java.Proyect.Servicios.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Empleados")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService iEmpleadoService;

    @GetMapping
    public ResponseEntity<List <Empleado>> GetListaEmpleados(){
        return ResponseEntity.ok(iEmpleadoService.listarEmpleados());
    }
    @GetMapping("/{ID_Empleado}")
    public ResponseEntity<Empleado> GetEmpleadoBYID(@PathVariable("ID_Empleado") Long ID){
        Optional<Empleado> EmpleadoById = iEmpleadoService.buscarEmpleado(ID);
        if (EmpleadoById.isPresent()) {
            return ResponseEntity.ok(EmpleadoById.get());
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Empleado> PostEmpleado(@RequestBody Empleado EMPLEADO) {
        return ResponseEntity.ok(iEmpleadoService.guardarEmpleado(EMPLEADO));
    }

    @PutMapping
    public  ResponseEntity<Empleado> PutEmpleado(@RequestBody Empleado EMPLEADO) {
        Optional<Empleado> EmpleadoById = iEmpleadoService.buscarEmpleado(EMPLEADO.getID());
        if (EmpleadoById.isPresent()) {
            return ResponseEntity.ok(iEmpleadoService.actualizarEmpleado(EMPLEADO));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/EliminarEmpleado/{ID_Empleado}")
    public  ResponseEntity<String> DeleteEmpleado(@PathVariable("ID_Empleado") Long ID){
        Optional<Empleado> EmpleadoEliminar = iEmpleadoService.buscarEmpleado(ID);
    if (EmpleadoEliminar.isPresent()) {
        iEmpleadoService.eliminarEmpleado(ID);
        return  ResponseEntity.ok("Empleado Eliminado Correctamente");
    }
    else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
