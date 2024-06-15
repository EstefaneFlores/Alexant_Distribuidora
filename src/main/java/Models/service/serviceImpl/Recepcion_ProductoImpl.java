package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Models.dao.IRecepcio_ProductoDao;

import Models.entitys.Recepcion_Producto;
import Models.service.service.IRecepcion_ProductoService;


public class Recepcion_ProductoImpl implements IRecepcion_ProductoService {

   @Autowired
    private IRecepcio_ProductoDao recepcion_ProductoDao;

    @Override
    public List<Recepcion_Producto> findAll() {
        return (List<Recepcion_Producto>) recepcion_ProductoDao.findAll();
    }

    @Override
    public void save(Recepcion_Producto recepcion_Producto) {
        recepcion_ProductoDao.save(recepcion_Producto);
    }
 
    @Override
    public Recepcion_Producto findOne(Integer id) {
        return recepcion_ProductoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        recepcion_ProductoDao.deleteById(id);
    }
    
}
