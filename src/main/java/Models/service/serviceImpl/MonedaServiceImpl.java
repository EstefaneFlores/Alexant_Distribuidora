package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Models.dao.IMonedaDao;
import Models.entitys.Moneda;
import Models.service.service.IMonedaService;

public class MonedaServiceImpl implements IMonedaService {

    @Autowired
    private IMonedaDao monedaDao;
    
    @Override
    public List<Moneda> findAll() {
        return (List<Moneda>) monedaDao.findAll();
    }

    @Override
    public void save(Moneda moneda) {
        monedaDao.save(moneda);
    }

    @Override
    public Moneda findOne(Integer id) {
        return monedaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        monedaDao.deleteById(id);
    }
}
