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
@Table(name = "pago")
public class Pago implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id_cargo;


    @Column(name = "tipo_pago")
    private String Tipo_pago;

    @Column(name = "estado_pago")
    private String estado_pago;

        @Column(name = "fec_registro_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_inicial;

        @Column(name = "fec_registro_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec_registro_final;



    @Column(name = "fec_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registroC;

    @Column(name = "fec_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionC;
    
    @Column(name = "usuario_registroC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_registroC;

    @Column(name = "usuario_modificacionC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuario_modificacionC;
    
    // ---------------------------------------

 

}
