package Models.entitys;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado  implements Serializable{
    
    private static long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_cliente;

    @Column(name = "ruta_empleado")
    private Integer ruta_empleado;

    @Column(name = "nro_codigo")
    private Integer nro_codigo;
    
    @Column(name = "estado_empleado")
    private Integer estado_empleado;
    
    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "usuario_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registro;

    @Column(name = "usuario_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacion;
}