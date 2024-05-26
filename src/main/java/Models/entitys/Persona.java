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

@Setter
@Getter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id_persona;

    @Column(name = "ci")
    private String ci;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "correo")
    private String correo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "id_estado")
    private String id_estado;

    @Column(name = "id_rol")
    private String id_rol;

    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    ////////////////////////////////////////////////////////////////////////////
    
}
