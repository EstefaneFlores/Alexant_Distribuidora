package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Persona;

public interface IPersonaService {
    
    public List<Persona> findAll();

    public void save(Persona persona);

    public Persona findOne(Integer id);

    public void delete(Integer id);

    /*public List<Persona> getListarPersonasActivas();

    Persona buscarPorCi(String ci);
*/
}
