package Models.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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

// testando essa menina
@Setter
@Getter
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = -2851287322656142733L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;

	private String nombre_producto;

	private String codigo_producto;

	private String stock_producto;

	private String cantidad_caja;

	private String fecha_registro;

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
}
