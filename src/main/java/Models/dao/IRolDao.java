package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Rol;

public interface IRolDao extends CrudRepository<Rol, Integer> {
    
}
