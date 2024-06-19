package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Venta;

public interface IVentaService {
    
    public List<Venta> findAll();

    public void save(Venta venta);

    public Venta findOne(Integer id);

    public void delete(Integer id);

    public List<Venta> getAllVentas();


}
