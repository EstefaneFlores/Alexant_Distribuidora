package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.ITiempo_en_cargoDao;
import Models.entitys.Tiempo_en_cargo;
import Models.service.service.ITiempo_en_cargoService;

@Service
public class Tiempo_en_cargoServiceImpl implements ITiempo_en_cargoService{
    @Autowired
    private ITiempo_en_cargoDao iTiempo_en_cargoDao;

    @Override
    public List<Tiempo_en_cargo> findAll() {
        return (List<Tiempo_en_cargo>) iTiempo_en_cargoDao.findAll();
    }

    @Override
    public void save(Tiempo_en_cargo tiempo_en_cargo) {
        iTiempo_en_cargoDao.save(tiempo_en_cargo);
    }

    @Override
    public Tiempo_en_cargo findOne(Integer id) {
        return iTiempo_en_cargoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iTiempo_en_cargoDao.deleteById(id);
    }

}
