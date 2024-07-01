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
@Table(name = "cargo")
public class Cargo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Integer id_cargo;


    @Column(name = "nombre_cargo")
    private String nombre_cargo;

    @Column(name = "estado_cargo")
    private String estado_cargo;

 	// -------------------------------------

	@Column(name = "registroCargo", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroCargo;

	@PrePersist
    protected void onCreate() {
        this.registroCargo = LocalDate.now();
    }

	@Column(name = "modificacionCargo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionCargo;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionCargo = LocalDate.now();
    }

	// ----------------
    
    @Column(name = "usuario_registroCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroCargo;

    @Column(name = "usuario_modificacionCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionCargo;
    
    // ---------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_tiempo_cargo", fetch = FetchType.LAZY)
    private List<TiempoCargo> tiempoCargos;

}
