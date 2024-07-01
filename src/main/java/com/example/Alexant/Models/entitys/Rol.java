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

@Setter
@Getter
@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_rol")
    private Integer id_rol;

    @Column (name = "tipo_rol")
    private String tipo_rol;

    @Column (name = "descripcion_rol")
    private String descripcion_rol;

    @Column (name = "estado_rol")
    private String estado_rol;

/*--------------------------------------------------- */

 	// -------------------------------------

	@Column(name = "registroRol", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroRol;

	@PrePersist
    protected void onCreate() {
        this.registroRol = LocalDate.now();
    }

	@Column(name = "modificacionRol")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionRol;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionRol = LocalDate.now();
    }

	// ----------------
    
    @Column(name = "usuario_registroRolRol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroRol;

    @Column(name = "usuario_modificacionRol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionRol;

/*-------------------------------RELACION CON USrROL--------------------------------------------*/

@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<UsuarioRol> usuariorol;

}
