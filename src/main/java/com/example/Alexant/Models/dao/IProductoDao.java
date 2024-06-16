package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Producto;

public interface IProductoDao extends CrudRepository<Producto, Integer>{
    
}
