package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.ITieneBieneDao;
import Models.entitys.TipoBiene;
import Models.service.service.ITipoBieneService;

@Service
public class TipoBieneServiceImpl implements ITipoBieneService {
    @Autowired
    private ITieneBieneDao iTieneBieneDao;

    @Override
    public List<TipoBiene> findAll() {
        return (List<TipoBiene>) iTieneBieneDao.findAll();
    }

    @Override
    public void save(TipoBiene tipo_Biene) {
        iTieneBieneDao.save(tipo_Biene);
    }

    @Override
    public TipoBiene findOne(Integer id) {
        return iTieneBieneDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iTieneBieneDao.deleteById(id);
    }
}
