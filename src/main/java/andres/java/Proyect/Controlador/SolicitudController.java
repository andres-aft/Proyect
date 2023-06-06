package andres.java.Proyect.Controlador;

import andres.java.Proyect.Modelo.Solicitud;
import andres.java.Proyect.Servicios.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Solicitud")
public class SolicitudController {
    private ISolicitudService iSolicitudService;

    public SolicitudController(ISolicitudService iSolicitudService) {
        this.iSolicitudService = iSolicitudService;
    }

    @GetMapping
    public ResponseEntity<List <Solicitud>> GetListSolicitudes(){
        return ResponseEntity.ok(iSolicitudService.getSolicitudes());
    }

    @GetMapping("/{ID_Solicitud}")
    public ResponseEntity<Solicitud> GetSolicitudByID(@PathVariable("ID_Solicitud") Long ID) {
        Optional<Solicitud> SolicitudById = iSolicitudService.getSolicitudById(ID);
        if (SolicitudById.isPresent()) {
            return ResponseEntity.ok(SolicitudById.get());
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Solicitud> PostSolicitud(@RequestBody Solicitud SOLICITUD) {
        return ResponseEntity.ok(iSolicitudService.postSolicitud(SOLICITUD));
    }

    @PutMapping
    public ResponseEntity<Solicitud> PutSolicitud(@RequestBody Solicitud SOLICITUD) {
        Optional<Solicitud> SolicitudById = iSolicitudService.getSolicitudById(SOLICITUD.getID());
        if (SolicitudById.isPresent()) {
            return ResponseEntity.ok(iSolicitudService.actualizarSolicitud(SOLICITUD));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/EliminarSolicitud/{ID_Solicitud}")
    public  ResponseEntity<String> DeleteSolicitud(@PathVariable("ID_Solicitud") Long ID) {
        Optional<Solicitud> SolicitudEliminar = iSolicitudService.getSolicitudById(ID);
        if (SolicitudEliminar.isPresent()) {
            iSolicitudService.eliminarSolicitud(ID);
            return  ResponseEntity.ok("Solicitud Eliminada Correctamente");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
