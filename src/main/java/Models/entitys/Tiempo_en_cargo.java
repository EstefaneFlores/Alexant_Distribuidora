package Models.entitys;

import java.io.Serializable;
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
@Table(name = "tiempo_en_cargo")
public class Tiempo_en_cargo  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiempo_en_cargo")
    private Integer id_tiempo_en_cargo;

    @Column(name = "FINAL_TCARGO")
    private Date FINAL_TCARGO;

    @Column(name = "INICIO_TCARGO")
    private Date INICIO_TCARGO;

    
    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fec_modificacionB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionB;
    
    @Column(name = "usuario_registroB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroB;

    @Column(name = "usuario_modificacionB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionB;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado Empleado;
}
