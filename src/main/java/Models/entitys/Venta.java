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
@Table(name = "venta")
public class Venta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id_venta;

    @Column(name = "total_venta")
    private float total_venta;

    @Column(name = "fecha_venta")
    private Date fecha_venta;

    @Column(name = "descuento")
    private float descuento;

    @Column(name = "nro_venta")
    private Integer nro_venta;

    @Column(name = "estado_venta")
    private Integer estado_venta;



    @Column(name = "fec_registroVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroVe;

    @Column(name = "fec_modificacionVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionVe;
    
    @Column(name = "usuario_registroVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroVe;

    @Column(name = "usuario_modificacionVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionVe;
}
