package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Detalle_Factura;

public interface IDetalle_FacturaService {
    
    public List<Detalle_Factura> findAll();

    public void save(Detalle_Factura detalle_Factura);

    public Detalle_Factura findOne(Integer id);

    public void delete(Integer id);


}
