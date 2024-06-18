package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id_cargo;

    @Column(name = "tipo_pago")
    private String Tipo_pago;

    @Column(name = "estado_pago")
    private Integer estado_pago;

    @Column(name = "fec_registro_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_inicial;

    @Column(name = "fec_registro_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_final;

    @Column(name = "fec_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroC;

    @Column(name = "fec_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionC;

    @Column(name = "usuario_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroC;

    @Column(name = "usuario_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionC;

    // ----------------RELACIÓN PAGO-----------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_forma_pago")
    private Forma_pago forma_pago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private Moneda moneda;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pagoVenta", joinColumns = @JoinColumn(name = "id_pago"), inverseJoinColumns = @JoinColumn(name = "id_venta"))
    private Set<Venta> ventas;

}
