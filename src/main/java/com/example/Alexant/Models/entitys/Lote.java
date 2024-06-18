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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lote")
public class Lote  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer id_lote;

    @Column(name = "cantidad_Lote")
    private Integer cantidad_Lote;

    @Column(name = "fecha_ingreso")
    private Date fecha_ingreso;
    
    @Column(name = "estado_lote")
    private Integer estado_lote;
    
    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "usuario_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registro;

    @Column(name = "usuario_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacion;

    // -------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote", fetch = FetchType.LAZY)
	private List<Recepcion_Producto> recepcion_Producto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote", fetch = FetchType.LAZY)
	private List<Detalle_lote> dDetalle_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedors;
}