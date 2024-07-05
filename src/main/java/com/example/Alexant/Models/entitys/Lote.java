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
@Table(name = "lote")
public class Lote  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer id_lote;

    @Column(name = "numero_lote")
    private Integer numero_lote;

    @Column(name = "cantidad_Lote")
    private Integer cantidad_Lote;

     @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_ingreso")
    private Date fecha_ingreso;
    
    @Column(name = "estado_lote")
    private String estado_lote;
    
	// -------------------------------------

	@Column(name = "registroLote", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroLote;

	@PrePersist
    protected void onCreate() {
        this.registroLote = LocalDate.now();
    }

	@Column(name = "modificacionLote")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionLote;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionLote = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroLote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroLote;

    @Column(name = "usuario_modificacionLote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionLote;

    // -------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote", fetch = FetchType.LAZY)
	private List<Recepcion_Producto> recepcion_producto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote", fetch = FetchType.LAZY)
	private List<Detalle_lote> detalle_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
}