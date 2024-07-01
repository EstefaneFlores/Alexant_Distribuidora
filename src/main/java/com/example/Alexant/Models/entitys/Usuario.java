package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate; 
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id_usuario;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "estado_usuario")
	private String estado_usuario;

	// -------------------------------------

	@Column(name = "registroUsuario", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroUsuario;

	@PrePersist
    protected void onCreate() {
        this.registroUsuario = LocalDate.now();
    }

	@Column(name = "modificacionUsuario")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionUsuario;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionUsuario = LocalDate.now();
    }

	// ----------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioRol> UsuarioRol;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private Empleado empleado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Venta> venta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona")
	private Persona persona;
	

}
