package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Detalle_Factura;

public interface IDetalle_facturaDao extends CrudRepository<Detalle_Factura, Integer>{
    
}
