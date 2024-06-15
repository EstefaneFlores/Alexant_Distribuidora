package Models.entitys;

import java.io.Serializable;
import java.sql.Date;
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

@Setter
@Getter
@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_rol")
    private Integer id_rol;

    @Column (name = "tipo_rol")
    private String tipo_rol;

    @Column (name = "descripcion_rol")
    private String descripcion_rol;

    @Column (name = "estado_rol")
    private String estado_rol;

/*--------------------------------------------------- */

    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    
    @Column(name = "usuario_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registro;

    @Column(name = "usuario_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacion;

/*-------------------------------RELACION CON USrROL--------------------------------------------*/

@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<UsuarioRol> usuariorol;

}
