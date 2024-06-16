package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Integer> {
    
}
