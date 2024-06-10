package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Producto;

public interface IProductoDao extends CrudRepository<Producto, Integer>{
    
}
