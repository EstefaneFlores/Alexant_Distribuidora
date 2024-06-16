package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IDetalle_facturaDao;
import com.example.Alexant.Models.entitys.Detalle_Factura;
import com.example.Alexant.Models.service.service.IDetalle_FacturaService;

@Service
public class Detalle_FacturaServiceImpl implements IDetalle_FacturaService{

    @Autowired
    private IDetalle_facturaDao iDetalle_FacturaDao;

    @Override
    public List<Detalle_Factura> findAll() {
        return (List<Detalle_Factura>) iDetalle_FacturaDao.findAll();
    }

    @Override
    public void save(Detalle_Factura detalle_Factura) {
        iDetalle_FacturaDao.save(detalle_Factura);
    }

    @Override
    public Detalle_Factura findOne(Integer id) {
        return iDetalle_FacturaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iDetalle_FacturaDao.deleteById(id);
    }

}
