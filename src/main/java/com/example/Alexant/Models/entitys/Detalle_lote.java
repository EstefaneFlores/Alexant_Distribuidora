package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_lote")
public class Detalle_lote  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_detalle_lote")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer id_detalle_lote;

    @Column(name = "fecha_vencimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_vencimento;

    @Column(name = "estado_det_lote")
    private String estado_det_lote;

    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

      @PrePersist
    protected void onCreate() {
        registro = new Date();
    }

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "usuario_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registro;

    @Column(name = "usuario_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacion;

    /*======================================== */

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lote")
	private Lote lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_lote_producto", joinColumns = @JoinColumn(name = "id_detalle_lote"), inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private Set<Producto> productos;
}
