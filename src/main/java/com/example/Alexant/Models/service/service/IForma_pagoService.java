package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Forma_pago;

public interface IForma_pagoService {
    
    public List<Forma_pago> findAll();

    public void save(Forma_pago forma_pago);

    public Forma_pago findOne(Integer id);

    public void delete(Integer id);
}
