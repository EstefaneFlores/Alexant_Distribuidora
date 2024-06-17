package com.example.Alexant.Models.entitys;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private String descripcion_biene;
    
    @Column(name = "fec_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroB;

    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionB;
    
    @Column(name = "usuario_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registro;

    @Column(name = "usuario_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacion;

// -----------------

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "id_tipo_biene")
// private TipoBiene tipoBiene;

// @ManyToMany(fetch = FetchType.LAZY)
// @JoinTable(name = "bienePersona", joinColumns = @JoinColumn(name = "id_biene"), inverseJoinColumns = @JoinColumn(name = "id_persona"))
// private Set<Persona> personas;

}