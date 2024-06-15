package Models.service.service;

import java.util.List;

import Models.entitys.Ruta;

public interface IRutaService {
    
     public List<Ruta> findAll();

    public void save(Ruta ruta);

    public Ruta findOne(Integer id);

    public void delete(Integer id);
}
