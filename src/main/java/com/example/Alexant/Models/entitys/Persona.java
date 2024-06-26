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
import jakarta.persistence.OneToMany;
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

    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
 
   @Column(name = "fec_modificacion")
   @Temporal(TemporalType.TIMESTAMP)
   private Date modificaion;
 
   @Column(name = "usuario_registro")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_registro;
 
   @Column(name = "usuario_modificacion")
   @Temporal(TemporalType.TIMESTAMP)
   private Date usuario_modificacion;
 /*------------------------------------------------------- */

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
 private List<Biene> biene;
 
 @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
 private List<Usuario> usuario;
}