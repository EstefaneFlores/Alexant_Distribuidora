package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.ICargoDao;
import com.example.Alexant.Models.dao.IFacturaDao;
import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.service.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService{
    @Autowired
    private IFacturaDao iFacturaDao;

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) iFacturaDao.findAll();
    }

    @Override
    public void save(Factura factura) {
        iFacturaDao.save(factura);
    }

    @Override
    public Factura findOne(Integer id) {
        return iFacturaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iFacturaDao.deleteById(id);
    }

}
