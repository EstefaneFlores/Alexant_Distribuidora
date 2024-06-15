package Models.service.service;

import java.util.List;

import Models.entitys.Tiempo_en_cargo;

public interface ITiempo_en_cargoService {
    
    public List<Tiempo_en_cargo> findAll();

    public void save(Tiempo_en_cargo tiempo_en_cargo);

    public Tiempo_en_cargo findOne(Integer id);

    public void delete(Integer id);


}
