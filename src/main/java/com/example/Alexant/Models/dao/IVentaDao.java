package com.example.Alexant.Models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Venta;

public interface IVentaDao extends CrudRepository<Venta, Integer>{

    @Query("select v from Venta v order by v.fecha_venta desc")
    public List<Venta> getAllVentas();
} 