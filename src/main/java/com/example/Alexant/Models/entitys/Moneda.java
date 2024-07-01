package com.example.Alexant.Models.entitys;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="moneda")
public class Moneda {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moneda")
    private Integer id_moneda;

    @Column(name = "nombre_moneda")
    private String nombre_moneda;

    @Column(name = "simbolo_moneda")
    private String simbolo_moneda;

    @Column(name = "valor_moneda")
    private String valor_moneda;

    @Column(name = "estado_moneda")
    private String estado_moneda;

 /*==============================================================*/
 /*==============================================================*/

	// -------------------------------------

	@Column(name = "registroMoneda", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroMoneda;

	@PrePersist
    protected void onCreate() {
        this.registroMoneda = LocalDate.now();
    }

	@Column(name = "modificacionMoneda")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionMoneda;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionMoneda = LocalDate.now();
    }

	// ----------------
   @Column(name = "usuario_registroMoneda")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_registroMoneda;
 
   @Column(name = "usuario_modificacionMoneda")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_modificacionMoneda;

   //  -------------------------

   @OneToOne(mappedBy = "moneda", cascade = CascadeType.ALL, orphanRemoval = true)
   private TipoCambio tipoCambio;
 
    
}


