package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IRutaDao;
import Models.entitys.Ruta;
import Models.service.service.IRutaService;

@Service
public class RutaServiceImpl implements IRutaService {

    @Autowired
    private IRutaDao rutaDao;

    @Override
    public List<Ruta> findAll() {
        return (List<Ruta>) rutaDao.findAll();
    }

    @Override
    public void save(Ruta ruta) {
        rutaDao.save(ruta);
    }

    @Override
    public Ruta findOne(Integer id) {
        return rutaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        rutaDao.deleteById(id);
    }
    
}
