package com.example.Alexant.Models.entitys;

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
@Table(name = "forma_pago")
public class Forma_pago {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_forma_pago")
	private Long id_forma_pago;

	@Column (name = "forma_pago")
	private String forma_pago;

	@Column (name = "monto")
	private String monto;
	
	@Column (name = "estado_forma_pago")
	private String estado_forma_pago;

/*------------------------------------------ */
	
	// -------------------------------------

	@Column(name = "registroForma_pago", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroForma_pago;

	@PrePersist
    protected void onCreate() {
        this.registroForma_pago = LocalDate.now();
    }

	@Column(name = "modificacionForma_pago")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionForma_pago;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionForma_pago = LocalDate.now();
    }

	// ----------------

@Column(name = "usuario_registroForma_pago")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_registroForma_pago;

@Column(name = "usuario_modificacionForma_pago")
@Temporal(TemporalType.TIMESTAMP)
private Date usuario_modificacionForma_pago;

/*----------------------RELACION CON MONEDA----------------------------------- */

@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moneda")
	private Moneda moneda;

}

