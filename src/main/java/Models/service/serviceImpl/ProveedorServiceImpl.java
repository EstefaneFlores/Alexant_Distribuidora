package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IProveedorDao;
import Models.entitys.Proveedor;
import Models.service.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    
    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    public List<Proveedor> findAll() {
        return (List<Proveedor>) proveedorDao.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    public Proveedor findOne(Integer id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        proveedorDao.deleteById(id);
    }
}
