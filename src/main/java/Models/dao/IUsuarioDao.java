package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
    
}
