package andres.java.Proyect.Modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @SequenceGenerator(name = "Empleado_sequence",sequenceName = "Empleado_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Empleado_sequence")
    private Long ID;
    @Column
    private String FECHA_INGRESO;
    @Column
    private String NOMBRE;
    @Column
    private Double SALARIO;

    public Empleado (String FECHA_INGRESO, String NOMBRE, Double SALARIO){
        this.FECHA_INGRESO = FECHA_INGRESO;
        this.NOMBRE = NOMBRE;
        this.SALARIO = SALARIO;
    }

    public Empleado(Long ID, String FECHA_INGRESO, String NOMBRE, Double SALARIO) {
        this.ID = ID;
        this.FECHA_INGRESO = FECHA_INGRESO;
        this.NOMBRE = NOMBRE;
        this.SALARIO = SALARIO;
    }

    public Empleado(Long ID) {
        this.ID = ID;
    }

    public String getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(String FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public Long getID() {
        return ID;
    }

    public Double getSALARIO() {
        return SALARIO;
    }

    public void setSALARIO(Double SALARIO) {
        this.SALARIO = SALARIO;
    }
}
