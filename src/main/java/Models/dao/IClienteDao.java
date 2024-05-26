package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{

    
} 