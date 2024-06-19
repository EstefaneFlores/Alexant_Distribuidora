package com.example.Alexant.Models.entitys;

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
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.TemporalType;

@Setter
@Getter
@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol")
    private Integer id_usr_rol;

    @Column(name = "fecha_expiracion")
    private Date fecha_expiracion;

    @Column(name = "estado_usuario_rol")
    private Integer estado_usr_rol;

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

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	private Rol rol;

}
