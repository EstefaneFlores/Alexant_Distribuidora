package Models.service.service;

import java.util.List;

import Models.entitys.Cargo;

public interface ICargoService {
    
    public List<Cargo> findAll();

    public void save(Cargo biene);

    public Cargo findOne(Integer id);

    public void delete(Integer id);


}
