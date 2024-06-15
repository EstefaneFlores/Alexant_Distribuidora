package Models.service.service;

import java.util.List;

import Models.entitys.Rol;

public interface IRolService {
    
    public List<Rol> findAll();

    public void save(Rol rol);

    public Rol findOne(Integer id);

    public void delete(Integer id);
}
