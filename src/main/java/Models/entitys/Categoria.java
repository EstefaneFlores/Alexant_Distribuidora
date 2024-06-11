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
    private Integer tipo_categoria;

    @Column(name = "estado_categoria")
    private Integer estado_categoria;
    
    
    @Column(name = "fec_registroCa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroCa;

    @Column(name = "fec_modificacionCa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionCa;

    @Column(name = "usuario_registroCa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroCa;

    @Column(name = "usuario_modificacionCa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionCa;
}