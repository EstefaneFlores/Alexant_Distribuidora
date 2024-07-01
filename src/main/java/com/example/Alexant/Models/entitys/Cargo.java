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
import jakarta.persistence.PrePersist;
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

    @Column(name = "fec_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroC;

     @PrePersist
    protected void onCreate() {
        registroC = new Date();
    }

    @Column(name = "fec_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionC;
    
    @Column(name = "usuario_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroC;

    @Column(name = "usuario_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionC;
    
    // ---------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_tiempo_cargo", fetch = FetchType.LAZY)
    private List<TiempoCargo> tiempoCargos;

}
