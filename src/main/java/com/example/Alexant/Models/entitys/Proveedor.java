package com.example.Alexant.Models.entitys;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_proveedor")
    private Integer id_proveedor;
   
    @Column (name = "nombre_proveedor")
    private String nombre_proveedor;

    @Column (name = "telefono_proveedor")
    private Integer telefono_proveedor;

    @Column (name = "descripcion_proveedor")
    private String descripcion_proveedor;

    @Column (name = "estado proveedor")
    private String estado_proveedor;

    /*----------------------------------------------------- */

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

/*--------------------------RELACION CON PRODUCTO------------------------------------------- */
@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    private Set<Producto> productos;
}