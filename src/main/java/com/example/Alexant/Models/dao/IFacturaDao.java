package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Integer> {
    
}
