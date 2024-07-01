package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @Column(name = "nro_nit")
    private Integer nro_nit;

    @Column(name = "nro_codigo")
    private Integer nro_codigo;

    @Column(name = "tipo_cliente")
    private String tipo_cliente;
    
    @Column(name = "razon_social")
    private String razon_social;

    @Column(name = "contacto_cliente")
    private String contacto_cliente;
    
    @Column(name = "estado_cliente")
    private String estado_cliente;
    


    
    @Column(name = "fec_registroCl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroCl;

       @PrePersist
    protected void onCreate() {
        registroCl = new Date();
    }

    @Column(name = "fec_modificacionCl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionCl;

    @Column(name = "usuario_registroCl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroCl;

    @Column(name = "usuario_modificacionCl")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionCl;

// -----------------------------------

@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_persona", nullable = false)
private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ruta")
	private Ruta ruta;

  

    
}