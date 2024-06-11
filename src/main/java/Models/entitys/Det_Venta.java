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
    
    private static final long serialVersionUID = 1L;
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

    
    
    @Column(name = "fec_registroDet_v")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroDet_v;

    @Column(name = "fec_modificacionDet_v")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionDet_v;

    @Column(name = "usuario_registroDet_v")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroDet_v;

    @Column(name = "usuario_modificacionDet_v")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionDet_v;
}