package Models.entitys;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_biene")
public class Tipo_Biene implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_biene")
    private Integer id_tipo_biene;

    @Column(name = "nombre_tipo_biene")
    private Integer nombre_tipo_biene;

    @Column(name = "estado_tipo_biene")
    private Integer estado_tipo_biene;

/*========================================================= */
/*========================================================= */

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


    // ------------------------
    
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_Biene", fetch = FetchType.LAZY)
    private List<Biene> biene;
	
}
