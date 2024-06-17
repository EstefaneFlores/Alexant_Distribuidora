package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    /* ========================================================= */

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

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_cargo")
    // private Cargo cargo;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_empleado")
    // private Empleado Empleado;

}
