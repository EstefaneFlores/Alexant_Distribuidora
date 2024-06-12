package Models.service.service;

import java.util.List;

import Models.entitys.Tipo_Biene;

public interface ITipoBieneService {

    public List<Tipo_Biene> findAll();

    public void save(Tipo_Biene tipo_Biene);

    public Tipo_Biene findOne(Integer id);

    public void delete(Integer id);

} 
