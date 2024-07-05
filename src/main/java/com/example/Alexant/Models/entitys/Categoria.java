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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "tipo_categoria")
    private String tipo_categoria;

    @Column(name = "estado_categoria")
    private String estado_categoria;
	// -------------------------------------

	@Column(name = "registroCargo", updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate  registroCategoria;

	@PrePersist
    protected void onCreate() {
        this.registroCategoria = LocalDate.now();
    }

	@Column(name = "modificacionCargo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modificacionCategoria;

    @PreUpdate
    protected void onUpdate() {
		this.modificacionCategoria = LocalDate.now();
    }

	// ----------------

    @Column(name = "usuario_registroCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroCategoria;

    @Column(name = "usuario_modificacionCargo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionCategoria;

// ----------------------------

@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Producto> producto;


}