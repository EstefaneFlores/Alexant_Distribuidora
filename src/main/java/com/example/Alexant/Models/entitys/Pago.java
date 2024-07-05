package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "pago")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id_pago;

    @Column(name = "tipo_pago")
    private String Tipo_pago;

    @Column(name = "estado_pago")
    private String estado_pago;

    @Column(name = "fec_registro_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_inicial;

    @Column(name = "fec_registro_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_final;

	// -------------------------------------

	@Column(name = "registroPago", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroPago;

	@PrePersist
    protected void onCreate() {
        this.registroPago = LocalDate.now();
    }

	@Column(name = "modificacionPago")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionPago;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionPago = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroPago;

    @Column(name = "usuario_modificacionPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionPago;

    // ----------------RELACIÓN PAGO-----------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_forma_pago")
    private Forma_pago forma_pago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

}
