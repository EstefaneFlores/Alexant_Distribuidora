package Models.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_biene")
public class Tipo_Biene implements Serializable {
    private static Long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_biene")
    private Integer id_tipo_biene;

    @Column(name = "nombre_tipo_biene")
    private Integer nombre_tipo_biene;

    @Column(name = "estado_tipo_biene")
    private Integer estado_tipo_biene;
}
