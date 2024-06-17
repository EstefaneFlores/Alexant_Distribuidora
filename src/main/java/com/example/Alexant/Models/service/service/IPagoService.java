package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Pago;

public interface IPagoService {
    
    public List<Pago> findAll();

    public void save(Pago biene);

    public Pago findOne(Integer id);

    public void delete(Integer id);


}
