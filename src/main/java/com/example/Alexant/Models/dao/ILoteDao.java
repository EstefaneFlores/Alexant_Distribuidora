package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Lote;

public interface ILoteDao extends CrudRepository<Lote, Integer> {
    
}
