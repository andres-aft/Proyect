package andres.java.Proyect.Servicios;

import andres.java.Proyect.Modelo.Solicitud;
import andres.java.Proyect.Repositorio.ISolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService implements ISolicitudService {

    @Autowired
    private ISolicitudRepository solicitudRepository;
    @Override
    public List<Solicitud> getSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public Optional<Solicitud> getSolicitudById(Long ID) {
        return solicitudRepository.findById(ID);
    }

    @Override
    public Solicitud postSolicitud(Solicitud SOLICITUD) {
        return solicitudRepository.save(SOLICITUD);
    }

    @Override
    public Solicitud actualizarSolicitud(Solicitud SOLICITUD) {
        return solicitudRepository.save(SOLICITUD);
    }

    @Override
    public void eliminarSolicitud(Long ID) {
        solicitudRepository.deleteById(ID);
    }
}
