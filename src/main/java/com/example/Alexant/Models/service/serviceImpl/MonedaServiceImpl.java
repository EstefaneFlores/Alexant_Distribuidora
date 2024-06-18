package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IMonedaDao;
import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.service.service.IMonedaService;

@Service
public class MonedaServiceImpl implements IMonedaService {

    @Autowired
    private IMonedaDao monedaDao;
    
    @Override
    public List<Moneda> findAll() {
        return (List<Moneda>) monedaDao.findAll();
    }

    @Override
    public void save(Moneda moneda) {
        monedaDao.save(moneda);
    }

    @Override
    public Moneda findOne(Integer id) {
        return monedaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        monedaDao.deleteById(id);
    }
}
