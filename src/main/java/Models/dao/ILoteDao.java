package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Lote;

public interface ILoteDao extends CrudRepository<Lote, Integer> {
    
}
