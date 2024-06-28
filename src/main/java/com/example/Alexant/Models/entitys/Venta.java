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
@Table(name = "venta")
public class Venta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id_venta;

    @Column(name = "total_venta")
    private float total_venta;

    @Column(name = "fecha_venta")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_venta;

    @Column(name = "descuento")
    private float descuento;

    @Column(name = "nro_venta")
    private Integer nro_venta;

    @Column(name = "estado_venta")
    private String estado_venta;

    /*========================================================*/

    @Column(name = "fec_registroVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroVe;

    @Column(name = "fec_modificacionVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionVe;
    
    @Column(name = "usuario_registroVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroVe;

    @Column(name = "usuario_modificacionVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionVe;

    // -------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Pago> pagos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Det_Venta> det_Ventas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Factura> facturas;

}
