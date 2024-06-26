package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IPagoDao;
import com.example.Alexant.Models.entitys.Pago;
import com.example.Alexant.Models.service.service.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService{
    @Autowired
    private IPagoDao iPagoDao;

    @Override
    public List<Pago> findAll() {
        return (List<Pago>) iPagoDao.findAll();
    }

    @Override
    public void save(Pago pago) {
        iPagoDao.save(pago);
    }

    @Override
    public Pago findOne(Integer id) {
        return iPagoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iPagoDao.deleteById(id);
    }

}
