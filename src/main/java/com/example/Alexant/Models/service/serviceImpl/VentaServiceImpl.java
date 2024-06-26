package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IVentaDao;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{
    @Autowired
    private IVentaDao iVentaDao;

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) iVentaDao.findAll();
    }

    @Override
    public void save(Venta venta) {
        iVentaDao.save(venta);
    }

    @Override
    public Venta findOne(Integer id) {
        return iVentaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iVentaDao.deleteById(id);
    }

    @Override
	public List<Venta> getAllVentas() {
		return iVentaDao.getAllVentas();
	}

}
