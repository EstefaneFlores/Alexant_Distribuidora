package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

// testando essa menina
@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_producto")
	private Long id_producto;

	@Column (name = "nombre_producto")
	private String nombre_producto;

	@Column (name = "codigo_producto")
	private String codigo_producto;
	
	@Column (name = "stock_producto")
	private String stock_producto;

	@Column (name = "cantidad_caja")
	private String cantidad_caja;

	@Column (name = "estado_pro")
	private String estado_pro;

/*------------------------------------------ */
	
	// -------------------------------------

	@Column(name = "registroProducto", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroProducto;

	@PrePersist
    protected void onCreate() {
        this.registroProducto = LocalDate.now();
    }

	@Column(name = "modificacionProducto")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionProducto;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionProducto = LocalDate.now();
    }

	// ----------------

@Column(name = "usuario_registroProducto")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_registroProducto;

@Column(name = "usuario_modificacionProducto")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_modificacionProducto;


/*---------------------------RELACION CON RECEPCION_PRODUCTO------------------------------------------------ */

@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_registro")
	private Recepcion_Producto recepcion_Producto;
/*----------------------------RELACION CON PROVEEDOR--------------------------------------------------- */

@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

/*-----------------------------RELACION CON DETALLE LOTE----------------------------------------------------- */

// @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "producto", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_detalle_lote"))
//     private Set<Detalle_lote> detalle_lote;
@ManyToMany
@JoinTable(name = "producto_detalle_lote", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_detalle_lote"))
private List<Detalle_lote> detalle_lote;

/*----------------------------------RELACION CON DET VENTA---------------------------------------------------- */
@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "producto_detventa",
        joinColumns = @JoinColumn(name = "id_producto"),
        inverseJoinColumns = @JoinColumn(name = "id_detalle_venta")
    )
    private Set<Det_Venta> det_venta;

/*-------------------------------RELACION CON CATEGORIA--------------------------------------*/

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Categoria> categorias;




}

