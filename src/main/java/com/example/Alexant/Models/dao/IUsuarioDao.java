package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
    
}
