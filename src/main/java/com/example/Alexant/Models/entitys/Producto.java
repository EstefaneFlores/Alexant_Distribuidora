package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
@Column(name = "fec_registro")
@Temporal(TemporalType.TIMESTAMP)
private Date registro;

@Column(name = "fec_modificacion")
@Temporal(TemporalType.TIMESTAMP)
private Date modificaion;

@Column(name = "usuario_registro")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_registro;

@Column(name = "usuario_modificacion")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_modificacion;


// // -----------------------------------------------

// 	@ManyToOne(fetch = FetchType.LAZY)
// 	@JoinColumn(name = "id_categoria")
// 	private Categoria categoria2;



// /*---------------------------RELACION CON RECEPCION_PRODUCTO------------------------------------------------ */

// @ManyToOne(fetch = FetchType.LAZY)
// 	@JoinColumn(name = "id_registro")
// 	private Recepcion_Producto recepcion_Producto;

// /*----------------------------RELACION CON PROVEEDOR--------------------------------------------------- */

// @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "producto", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_proveedor"))
//     private Set<Proveedor> proveedor;

// /*-----------------------------RELACION CON DETALLE LOTE----------------------------------------------------- */

// @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "producto", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_detalle_lote"))
//     private Set<Detalle_lote> detalle_lote;

// /*----------------------------------RELACION CON DET VENTA---------------------------------------------------- */

// @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "producto", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_detalleVenta"))
//     private Set<Det_Venta> det_venta;

// /*-------------------------------RELACION CON CATEGORIA--------------------------------------*/

// @ManyToOne(fetch = FetchType.LAZY)
// 	@JoinColumn(name = "id_categoria")
// 	private Categoria categoria;




}

