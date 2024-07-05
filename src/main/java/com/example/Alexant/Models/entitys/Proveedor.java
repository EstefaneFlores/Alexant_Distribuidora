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

    @Column (name = "estado_proveedor")
    private String estado_proveedor;

    /*----------------------------------------------------- */

	// -------------------------------------

	@Column(name = "registroProveedor", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroProveedor;

	@PrePersist
    protected void onCreate() {
        this.registroProveedor = LocalDate.now();
    }

	@Column(name = "modificacionProveedor")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionProveedor;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionProveedor = LocalDate.now();
    }

	// ----------------
    
    @Column(name = "usuario_registroProveedor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroProveedor;

    @Column(name = "usuario_modificacionProveedor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionProveedor;

/*--------------------------RELACION CON PRODUCTO------------------------------------------- */

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<Lote> lote;

}