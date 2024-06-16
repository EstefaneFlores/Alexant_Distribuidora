package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, Integer>{
    
}
