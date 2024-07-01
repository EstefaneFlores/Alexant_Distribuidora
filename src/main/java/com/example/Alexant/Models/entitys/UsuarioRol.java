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
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.TemporalType;

@Setter
@Getter
@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol")
    private Integer id_usr_rol;

    @Column(name = "fecha_expiracion")
    private Date fecha_expiracion;

    @Column(name = "estado_usr_rol")
    private String estado_usr_rol;

/*========================================================= */
/*========================================================= */
	// -------------------------------------

	@Column(name = "registroUsuarioRol", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroUsuarioRol;

	@PrePersist
    protected void onCreate() {
        this.registroUsuarioRol = LocalDate.now();
    }

	@Column(name = "modificacionUsuarioRol")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionUsuarioRol;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionUsuarioRol = LocalDate.now();
    }

	// ----------------
 
    @Column(name = "usuario_registroUsuarioRol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroUsuarioRol;
 
    @Column(name = "usuario_modificacionUsuarioRol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionUsuarioRol;

    // -------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	private Rol rol;

}
