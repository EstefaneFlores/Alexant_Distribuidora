package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "tipo_cambio")
public class TipoCambio implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cambio")
    private Integer id_tipo_cambio;

    @Column(name = "valor_tipo_cambio")
    private Integer valor_tipo_cambio;

    @Column(name = "estado_tipo_cambio")
    private Integer estado_tipo_cambio;

/*========================================================= */
/*========================================================= */

   	// -------------------------------------

	@Column(name = "registroTipoCambio", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroTipoCambio;

	@PrePersist
    protected void onCreate() {
        this.registroTipoCambio = LocalDate.now();
    }

	@Column(name = "modificacionTipoCambio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionTipoCambio;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionTipoCambio = LocalDate.now();
    }

	// ----------------
 
    @Column(name = "usuario_registroTipoCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroTipoCambio;
 
    @Column(name = "usuario_modificacionTipoCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionTipoCambio;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_modena")
    private Moneda moneda;

 }
