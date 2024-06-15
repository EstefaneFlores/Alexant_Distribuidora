package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Forma_pago;

public interface IForma_pagoDao extends CrudRepository<Forma_pago, Integer> {
    
}
