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
    private Float precio_producto;

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

  	// -------------------------------------

	@Column(name = "registroRecepcion_Producto", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroRecepcion_Producto;

	@PrePersist
    protected void onCreate() {
        this.registroRecepcion_Producto = LocalDate.now();
    }

	@Column(name = "modificacionRecepcion_Producto")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionRecepcion_Producto;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionRecepcion_Producto = LocalDate.now();
    }

	// ----------------
    
    @Column(name = "usuario_registroRecepcion_Producto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroRecepcion_Producto;

    @Column(name = "usuario_modificacionRecepcion_Producto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionRecepcion_Producto;

/*-------------------RELACION CON PRODUCTO----------------------------------- */    

@OneToMany(cascade = CascadeType.ALL, mappedBy = "recepcion_producto", fetch = FetchType.LAZY)
    private List<Producto> productos;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_lote")
private Lote lote;
    
}
