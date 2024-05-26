package Models.entitys;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "recepcion_producto")
public class Recepcion_Producto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    @Column (name = "precio_producto")
    private String precio_producto;

    @Column (name = "cantidad_caja")
    private Integer cantidad_caja;

    @Column (name = "fecha_ingreso")
    private Date fecha_ingreso;

    @Column (name = "fecha_registro_producto")
    private Date fecha_registro_producto;

    @Column (name = "fecha_vencimento")
    private Date fecha_vencimeinto;

    @Column (name = "precio_venta")
    private Float precio_venta;

    @Column (name = "estado_recepcion_producto")
    private String estado_recepcion_producto;


    
}
