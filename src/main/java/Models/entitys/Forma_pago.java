package Models.entitys;

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
@Table(name = "forma_pago")
public class Forma_pago {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_forma_pago")
	private Long id_forma_pago;

	@Column (name = "forma_pago")
	private String forma_pago;

	@Column (name = "monto")
	private String monto;
	
	@Column (name = "estado_forma_pago")
	private String estado_forma_pago;

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

/*----------------------RELACION CON MONEDA----------------------------------- */

@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moneda")
	private Moneda moneda;

}

