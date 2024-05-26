package Models.dao;

import org.springframework.data.repository.CrudRepository;

import Models.entitys.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, Integer>{
    
}
