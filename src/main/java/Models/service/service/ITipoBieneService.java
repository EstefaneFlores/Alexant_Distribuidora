package Models.service.service;

import java.util.List;

import Models.entitys.TipoBiene;

public interface ITipoBieneService {

    public List<TipoBiene> findAll();

    public void save(TipoBiene tipoBiene);

    public TipoBiene findOne(Integer id);

    public void delete(Integer id);

} 
