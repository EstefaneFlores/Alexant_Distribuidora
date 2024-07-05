package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detalle_factura")
public class Detalle_Factura  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleFactura")
    private Integer id_detalleFactura;

    @Column(name = "cantidad_factura")
    private Integer cantidad_factura;

    @Column(name = "sub_totalFactura")
    private Integer sub_totalFactura;
    
    @Column(name = "subtotal_descuento")
    private Integer subtotal_descuento;

    @Column(name = "estado_det_f")
    private String estado_det_f;

	// -------------------------------------

	@Column(name = "registroDetalle_Factura", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroDetalle_Factura;

	@PrePersist
    protected void onCreate() {
        this.registroDetalle_Factura = LocalDate.now();
    }

	@Column(name = "modificacionDetalle_Factura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionDetalle_Factura;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionDetalle_Factura = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroDetalle_Factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroDetalle_Factura;

    @Column(name = "usuario_modificacionDetalle_Factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionDetalle_Factura;

    // -----------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_detalle_Venta")
	private Det_Venta det_venta;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_factura")
	private Factura factura;

}