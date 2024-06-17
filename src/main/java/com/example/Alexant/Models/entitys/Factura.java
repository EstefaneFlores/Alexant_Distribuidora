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

@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer id_factura;

    @Column(name = "nro_factura")
    private Integer nro_factura;

    @Column(name = "descripcion_factura")
    private Integer descripcion_factura;

    @Column(name = "fecha_factura")
    private Integer fecha_factura;
    
    @Column(name = "estado_fac")
    private Integer estado_fac;

    @Column(name = "total_descuento")
    private Integer total_descuento;
    
    @Column(name = "total_factura")
    private Integer total_factura;
    
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

// ----------------------------------------

    // @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_venta")
	// private Venta venta;


    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.LAZY)
	// private List<Det_Venta> preinscripciones;

}