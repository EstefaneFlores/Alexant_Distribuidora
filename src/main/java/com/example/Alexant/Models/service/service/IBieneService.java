package com.example.Alexant.Models.service.service;
import java.util.List;

import com.example.Alexant.Models.entitys.Biene;

public interface IBieneService {
    public List<Biene> findAll();

    public void save(Biene biene);

    public Biene findOne(Integer id);

    public void delete(Integer id);
} 