package Models.service.service;

import java.util.List;

import Models.entitys.Biene;

public interface IBieneService {
    
    public List<Biene> findAll();

    public void save(Biene biene);

    public Biene findOne(Integer id);

    public void delete(Integer id);


}
