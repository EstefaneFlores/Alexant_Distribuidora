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
@Table(name = "det_venta")
public class Det_Venta  implements Serializable{
    
    private static long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleVenta")
    private Integer id_detalleVenta;

    @Column(name = "cantidad_det_venta")
    private Integer cantidad_det_venta;

    @Column(name = "sub_total")
    private Integer sub_total;

    @Column(name = "sub_total_descuento")
    private Integer sub_total_descuento;
    
    @Column(name = "unidad_medida")
    private Integer unidad_medida;
    
    @Column(name = "estado_det_venta")
    private Integer estado_det_venta;
    
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