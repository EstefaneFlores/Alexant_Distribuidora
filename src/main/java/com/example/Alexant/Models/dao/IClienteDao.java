package com.example.Alexant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{

    
} 