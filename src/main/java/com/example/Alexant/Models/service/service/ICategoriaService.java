package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Categoria;

public interface ICategoriaService {
    
    public List<Categoria> findAll();

    public void save(Categoria categoria);

    public Categoria findOne(Integer id);

    public void delete(Integer id);


}
