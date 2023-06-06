package andres.java.Proyect.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Solicitud")
public class Solicitud {

    @Id
    @SequenceGenerator(name = "Solicitud_sequence",sequenceName = "Solicitud_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Solicitud_sequence")
    private long ID;
    @Column
    private String CODIGO;
    @Column
    private String DESCRIPCION;
    @Column
    private String RESUMEN;
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado EMPLEADO;

    public Solicitud(String CODIGO, String DESCRIPCION, String RESUMEN, Empleado EMPLEADO) {
        this.CODIGO = CODIGO;
        this.DESCRIPCION = DESCRIPCION;
        this.RESUMEN = RESUMEN;
        this.EMPLEADO = EMPLEADO;
    }

    public Solicitud(long ID, String CODIGO, String DESCRIPCION, String RESUMEN, Empleado EMPLEADO) {
        this.ID = ID;
        this.CODIGO = CODIGO;
        this.DESCRIPCION = DESCRIPCION;
        this.RESUMEN = RESUMEN;
        this.EMPLEADO = EMPLEADO;
    }

    public Solicitud(long ID) {
        this.ID = ID;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getRESUMEN() {
        return RESUMEN;
    }

    public void setRESUMEN(String RESUMEN) {
        this.RESUMEN = RESUMEN;
    }

    public Empleado getEMPLEADO() {
        return EMPLEADO;
    }

    public long getID() {
        return ID;
    }

    public void setEMPLEADO(Empleado EMPLEADO) {
        this.EMPLEADO = EMPLEADO;
    }
}
