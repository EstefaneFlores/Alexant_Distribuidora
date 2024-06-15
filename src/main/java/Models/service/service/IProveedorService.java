package Models.service.service;

import java.util.List;

import Models.entitys.Proveedor;

public interface IProveedorService {
    
    public List<Proveedor> findAll();

    public void save(Proveedor proveedor);

    public Proveedor findOne(Integer id);

    public void delete(Integer id);
}
