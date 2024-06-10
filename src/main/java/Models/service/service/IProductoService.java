package Models.service.service;

import java.util.List;

import Models.entitys.Producto;

public interface IProductoService {
    
     public List<Producto> findAll();

    public void save(Producto persona);

    public Producto findOne(Integer id);

    public void delete(Integer id);
}
