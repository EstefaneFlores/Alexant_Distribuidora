package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IForma_pagoDao;
import com.example.Alexant.Models.entitys.Forma_pago;
import com.example.Alexant.Models.service.service.IForma_pagoService;

@Service
public class Forma_pagoServiceImpl implements IForma_pagoService {

    @Autowired
    private IForma_pagoDao forma_pagoDao;

    @Override
    public List<Forma_pago> findAll() {
        return (List<Forma_pago>) forma_pagoDao.findAll();
    }

    @Override
    public void save(Forma_pago forma_pago) {
        forma_pagoDao.save(forma_pago);
    }

    @Override
    public Forma_pago findOne(Integer id) {
        return forma_pagoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        forma_pagoDao.deleteById(id);
    }
     
    
}
