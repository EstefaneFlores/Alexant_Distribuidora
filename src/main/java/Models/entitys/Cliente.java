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
@Table(name = "cliente")
public class Cliente  implements Serializable{
    
    private static long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @Column(name = "nro_nit")
    private Integer nro_nit;

    @Column(name = "nro_codigo")
    private Integer nro_codigo;

    @Column(name = "tipo_cliente")
    private Integer tipo_cliente;
    
    @Column(name = "razon_social")
    private Integer razon_social;

    @Column(name = "contacto_cliente")
    private Integer contacto_cliente;
    
    @Column(name = "estado_cliente")
    private Integer estado_cliente;
    
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
}