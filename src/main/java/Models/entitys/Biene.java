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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "biene")
public class Biene  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biene")
    private Integer id_biene;

    @Column(name = "codigo_biene")
    private Integer codigo_biene;

    @Column(name = "nombre_biene")
    private Integer nombre_biene;

    @Column(name = "estado_biene")
    private Integer estado_biene;

    @Column(name = "descripcion_biene")
    private Integer descripcion_biene;

    
    @Column(name = "fec_registroB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroB;

    @Column(name = "fec_modificacionB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionB;
    
    @Column(name = "usuario_registroB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroB;

    @Column(name = "usuario_modificacionB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionB;



       @OneToMany(cascade = CascadeType.ALL, mappedBy = "biene", fetch = FetchType.LAZY)
    private List<Tipo_Biene> tipo_Biene;


    @ManyToMany(mappedBy = "bienes")
    private List<Persona> personas;
}
