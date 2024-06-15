package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IProductoDao;
import Models.entitys.Producto;
import Models.service.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
    
    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }
 
    @Override
    public Producto findOne(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        productoDao.deleteById(id);
    }

}
