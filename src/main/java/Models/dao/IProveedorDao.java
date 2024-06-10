package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Proveedor;

public interface IProveedorDao extends CrudRepository<Proveedor, Integer>{
    
}
