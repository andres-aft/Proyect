package andres.java.Proyect.Servicios;

import andres.java.Proyect.Modelo.Solicitud;

import java.util.List;
import java.util.Optional;

public interface ISolicitudService {
    List<Solicitud> getSolicitudes();
    Optional<Solicitud> getSolicitudById(Long ID);
    Solicitud postSolicitud(Solicitud SOLICITUD);
    Solicitud actualizarSolicitud(Solicitud SOLICITUD);
    void eliminarSolicitud(Long ID);
}