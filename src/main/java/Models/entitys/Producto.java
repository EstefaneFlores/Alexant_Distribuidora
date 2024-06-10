package Models.entitys;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

// testando essa menina
@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_producto")
	private Long id_producto;

	@Column (name = "nombre_producto")
	private String nombre_producto;

	@Column (name = "codigo_producto")
	private String codigo_producto;
	
	@Column (name = "stock_producto")
	private String stock_producto;

	@Column (name = "cantidad_caja")
	private String cantidad_caja;

/*------------------------------------------ */
	
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

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	// private List<Tutor> tutor;

	// @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	// private Estudiante estudiante;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	// private List<Firma> firma;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	// private List<Asistencia> asistencias;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
	// private List<Preinscripcion> preinscripciones;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_universidad")
	// private Universidad universidad;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    // private List<Usuario> usuario;

	/*
	@Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yy")
    private Date fechaRegistro;

    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date horaRegistro;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
	*/
}
