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
@Table(name = "biene")
public class Biene  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biene")
    private Integer id_biene;

    @Column(name = "codigo_biene")
    private String codigo_biene;

    @Column(name = "nombre_biene")
    private String nombre_biene;

    @Column(name = "estado_biene")
    private String estado_biene;

    @Column(name = "descripcion_biene")
    private String descripcion_biene;
    
	// -------------------------------------

	@Column(name = "registroBiene", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroBiene;

	@PrePersist
    protected void onCreate() {
        this.registroBiene = LocalDate.now();
    }

	@Column(name = "modificacionBiene")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionBiene;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionBiene = LocalDate.now();
    }

	// ----------------
    @Column(name = "usuario_registroBiene")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroBiene;

    @Column(name = "usuario_modificacionBiene")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionBiene;

// -----------------


@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_biene")
    private TipoBiene tipo_biene;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_persona")
private Persona persona;

}