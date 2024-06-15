package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IRolDao;
import Models.entitys.Rol;
import Models.service.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDao rolDao;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public Rol findOne(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }
    
}
