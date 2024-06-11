package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IPersonaDao;
import Models.entitys.Persona;
import Models.service.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{
    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public Persona findOne(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        personaDao.deleteById(id);
    }

    /*@Override
    public List<Persona> getListarPersonasActivas() {
        return personaDao.getListarPersonasActivas();
    }
    @Override
    public Persona buscarPorCi(String ci) {
        return personaDao.buscarPorCi(ci); 
    }
    */
}