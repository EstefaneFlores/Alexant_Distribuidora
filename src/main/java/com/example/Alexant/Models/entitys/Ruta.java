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
@Table(name = "ruta")
public class Ruta implements Serializable{
    
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_ruta")
    private Integer id_ruta;

    @Column (name = "nro_ruta")
    private Integer nro_ruta;

    @Column (name = "estado_ruta")
    private String estado_ruta;

/*--------------------------------------------------- */

   	// -------------------------------------

	@Column(name = "registroRuta", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroRuta;

	@PrePersist
    protected void onCreate() {
        this.registroRuta = LocalDate.now();
    }

	@Column(name = "modificacionRuta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionRuta;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionRuta = LocalDate.now();
    }

	// ----------------
    
    @Column(name = "usuario_registroRuta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroRuta;

    @Column(name = "usuario_modificacionRuta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionRuta;

/*--------------------RELACION CON CLIENTE------------------------------ */

@OneToMany(cascade = CascadeType.ALL, mappedBy = "ruta", fetch = FetchType.LAZY)
	private List<Cliente> cliente;

}
