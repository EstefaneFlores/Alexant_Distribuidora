package com.example.Alexant.Models.service.service;
import java.util.List;

import com.example.Alexant.Models.entitys.TiempoCargo;

public interface ITiempoCargoService {
    
    public List<TiempoCargo> findAll();

    public void save(TiempoCargo tiempoCargo);

    public TiempoCargo findOne(Integer id);

    public void delete(Integer id);

}
