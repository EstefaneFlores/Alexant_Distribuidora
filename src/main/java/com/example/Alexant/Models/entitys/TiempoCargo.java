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
@Table(name = "tiempo_cargo")
public class TiempoCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiempo_cargo")
    private Integer id_tiempo_cargo;

    @Column(name = "inicio_tcargo")
    private String inicio_tcargo;

    @Column(name = "final_tcargo")
    private String final_tcargo;

    @Column(name = "estado_tcargo")
    private Integer estado_tcargo;

    /* ========================================================= */

 	// -------------------------------------

	@Column(name = "registroTiempoCargo", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroTiempoCargo;

	@PrePersist
    protected void onCreate() {
        this.registroTiempoCargo = LocalDate.now();
    }

	@Column(name = "modificacionTiempoCargo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionTiempoCargo;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionTiempoCargo = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroTiempoCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroTiempoCargo;

    @Column(name = "usuario_modificacionTiempoCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionTiempoCargo;

    /* ========================================================= */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

}
