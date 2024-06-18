package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Detalle_lote;


public interface IDetalleLoteService {

    public List<Detalle_lote> findAll();

    public void save(Detalle_lote detalle_lote);

    public Detalle_lote findOne(Integer id);

    public void delete(Integer id);

} 