package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Det_Venta;

public interface IDet_VentaService {
    
    public List<Det_Venta> findAll();

    public void save(Det_Venta det_Venta);

    public Det_Venta findOne(Integer id);

    public void delete(Integer id);


}
