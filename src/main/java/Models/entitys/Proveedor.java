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

@Setter
@Getter
@Entity
@Table (name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_proveedor;
   
    @Column (name = "nombre_proveedor")
    private String nombre_proveedor;

    @Column (name = "telefono_proveedor")
    private Integer telefono_proveedor;

    @Column (name = "descripcion_proveedor")
    private String descripcion_proveedor;

    @Column (name = "estado proveedor")
    private String estado_proveedor;

    
}
