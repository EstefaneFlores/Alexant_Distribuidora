package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Column (name = "id_registro")
    private Integer id_registro;

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

/*--------------------------------------------------- */

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

/*-------------------RELACION CON PRODUCTO----------------------------------- */    

@OneToMany(cascade = CascadeType.ALL, mappedBy = "recepcion_Producto", fetch = FetchType.LAZY)
    private List<Producto> productos;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_lote")
private Lote lote;
    
}
