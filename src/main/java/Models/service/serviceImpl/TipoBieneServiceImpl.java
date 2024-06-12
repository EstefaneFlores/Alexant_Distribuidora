package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Models.dao.ITieneBieneDao;
import Models.entitys.Tipo_Biene;
import Models.service.service.ITipoBieneService;

public class TipoBieneServiceImpl implements ITipoBieneService {
     @Autowired
    private ITieneBieneDao iTieneBieneDao;

    @Override
    public List<Tipo_Biene> findAll() {
        return (List<Tipo_Biene>) iTieneBieneDao.findAll();
    }

    @Override
    public void save(Tipo_Biene tipo_Biene) {
        iTieneBieneDao.save(tipo_Biene);
    }

    @Override
    public Tipo_Biene findOne(Integer id) {
        return iTieneBieneDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iTieneBieneDao.deleteById(id);
    }
}
