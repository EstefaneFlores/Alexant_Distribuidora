package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IBieneDao;
import Models.entitys.Biene;
import Models.service.service.IBieneService;

@Service
public class BieneServiceImpl implements IBieneService{
    @Autowired
    private IBieneDao iBieneDao;

    @Override
    public List<Biene> findAll() {
        return (List<Biene>) iBieneDao.findAll();
    }

    @Override
    public void save(Biene biene) {
        iBieneDao.save(biene);
    }

    @Override
    public Biene findOne(Integer id) {
        return iBieneDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iBieneDao.deleteById(id);
    }

}
