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
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "nombre_persona")
    private String nombre_persona;

    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @Column(name = "apellido_materno")
    private String apellido_materno;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ci")
    private String ci;

    @Column(name = "numero_celular")
    private String numero_celular;

    @Column(name = "email")
    private String email;

    @Column(name = "estado_per")
    private String estado_per;

 /*------------------------------------------------------- */

   	// -------------------------------------

	@Column(name = "registroPersona", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroPersona;

	@PrePersist
    protected void onCreate() {
        this.registroPersona = LocalDate.now();
    }

	@Column(name = "modificacionPersona")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionPersona;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionPersona = LocalDate.now();
    }

	// ----------------
 
   @Column(name = "usuario_registroPersona")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_registroPersona;
 
   @Column(name = "usuario_modificacionPersona")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_modificacionPersona;
 /*------------------------------------------------------- */

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
 private List<Biene> biene;
 
 @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
 private List<Usuario> usuario;
}