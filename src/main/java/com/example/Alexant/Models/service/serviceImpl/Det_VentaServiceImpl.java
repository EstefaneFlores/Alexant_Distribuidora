package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IDet_VentaDao;
import com.example.Alexant.Models.entitys.Det_Venta;
import com.example.Alexant.Models.service.service.IDet_VentaService;

@Service
public class Det_VentaServiceImpl implements IDet_VentaService{

    @Autowired
    private IDet_VentaDao iDet_VentaDao;

    @Override
    public List<Det_Venta> findAll() {
        return (List<Det_Venta>) iDet_VentaDao.findAll();
    }

    @Override
    public void save(Det_Venta det_venta) {
        iDet_VentaDao.save(det_venta);
    }

    @Override
    public Det_Venta findOne(Integer id) {
        return iDet_VentaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iDet_VentaDao.deleteById(id);
    }

}
