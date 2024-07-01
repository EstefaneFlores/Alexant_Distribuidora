package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    private String descripcion_factura;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_factura")
    private Date fecha_factura;

    @Column(name = "total_descuento")
    private Integer total_descuento;
    
    @Column(name = "total_factura")
    private float total_factura;
        
    @Column(name = "estado_fac")
    private String estado_fac;
    
	// -------------------------------------

	@Column(name = "registroFactura", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroFactura;

	@PrePersist
    protected void onCreate() {
        this.registroFactura = LocalDate.now();
    }

	@Column(name = "modificacionFactura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionFactura;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionFactura = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroFactura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroFactura;

    @Column(name = "usuario_modificacionFactura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionFactura;

// ----------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta")
	private Venta venta;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.LAZY)
	private List<Detalle_Factura> detalle_Facturas;

}