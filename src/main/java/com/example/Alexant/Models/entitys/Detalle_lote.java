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
@Table(name = "detalle_lote")
public class Detalle_lote  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_detalle_lote") 
    private Integer id_detalle_lote;

    @Column(name = "fecha_vencimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_vencimento;

    @Column(name = "estado_det_lote")
    private String estado_det_lote;

	// -------------------------------------

	@Column(name = "registroDetalle_lote", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroDetalle_lote;

	@PrePersist
    protected void onCreate() {
        this.registroDetalle_lote = LocalDate.now();
    }

	@Column(name = "modificacionDetalle_lote")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionDetalle_lote;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionDetalle_lote = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroDetalle_lote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroDetalle_lote;

    @Column(name = "usuario_modificacionDetalle_lote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionDetalle_lote;

    /*======================================== */

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lote")
	private Lote lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "detalle_lote", fetch = FetchType.LAZY)
private List<Producto> producto;

}
