package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Integer>{

    
}
