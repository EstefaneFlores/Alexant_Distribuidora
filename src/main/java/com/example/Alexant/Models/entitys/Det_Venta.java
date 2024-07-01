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
import jakarta.persistence.ManyToMany;
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
    private String unidad_medida;
    
    @Column(name = "estado_det_venta")
    private String estado_det_venta;

    
    
	// -------------------------------------

	@Column(name = "registroDet_Venta", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroDet_Venta;

	@PrePersist
    protected void onCreate() {
        this.registroDet_Venta = LocalDate.now();
    }

	@Column(name = "modificacionDet_Venta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionDet_Venta;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionDet_Venta = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroDet_Venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroDet_Venta;

    @Column(name = "usuario_modificacionDet_Venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionDet_Venta;

    // ------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "det_venta", fetch = FetchType.LAZY)
    private List<Detalle_Factura> detalle_factura;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta")
	private Venta venta;

    @ManyToMany(mappedBy = "det_venta")
    private List<Producto> productos;
}