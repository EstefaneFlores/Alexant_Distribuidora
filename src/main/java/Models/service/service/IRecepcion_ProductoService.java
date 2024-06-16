package Models.service.service;

import java.util.List;

import Models.entitys.Recepcion_Producto;

public interface IRecepcion_ProductoService {
    
     public List<Recepcion_Producto> findAll();

    public void save(Recepcion_Producto recepcion_Producto);

    public Recepcion_Producto findOne(Integer id);

    public void delete(Integer id);
}
