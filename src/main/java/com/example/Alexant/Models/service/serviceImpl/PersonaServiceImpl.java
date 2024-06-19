package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IPersonaDao;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.service.service.IPersonaService;

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

    @Override
    public Persona buscarPorCi(String ci) {
        return personaDao.buscarPorCi(ci); 
    }
    
    
	@Override
	public List<Persona> getAllPersonaCiEmail(String ci, String email) {
		return personaDao.getAllPersonaCiEmail(ci, email);
	}

    @Override
    public List<Persona> getListarPersonasActivas() {
        return personaDao.getListarPersonasActivas();
    }
}
