package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Rol;

public interface IRolService {
    
    public List<Rol> findAll();

    public void save(Rol rol);

    public Rol findOne(Integer id);

    public void delete(Integer id);
}
