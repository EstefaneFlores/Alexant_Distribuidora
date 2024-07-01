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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "empleado")
public class Empleado  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Column(name = "ruta_empleado")
    private Integer ruta_empleado;

    @Column(name = "nro_codigo")
    private Integer nro_codigo;
    
    @Column(name = "estado_empleado")
    private String estado_empleado;
    
   	// -------------------------------------

	@Column(name = "registroEmpleado", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroEmpleado;

	@PrePersist
    protected void onCreate() {
        this.registroEmpleado = LocalDate.now();
    }

	@Column(name = "modificacionEmpleado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionEmpleado;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionEmpleado = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroEmpleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroEmpleado;

    @Column(name = "usuario_modificacionEmpleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionEmpleado;

    /*=======================================================*/

    @OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<TiempoCargo> tiempoCargos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<Detalle_lote> detalle_lotes;


}