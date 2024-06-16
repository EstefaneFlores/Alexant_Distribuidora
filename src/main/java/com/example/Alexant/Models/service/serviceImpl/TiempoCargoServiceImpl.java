package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.ITiempoCargoDao;
import com.example.Alexant.Models.entitys.TiempoCargo;
import com.example.Alexant.Models.service.service.ITiempoCargoService;

@Service
public class TiempoCargoServiceImpl implements ITiempoCargoService{

    @Autowired
    private ITiempoCargoDao tiempoCargoDao;

    @Override
    public List<TiempoCargo> findAll() {
        return (List<TiempoCargo>) tiempoCargoDao.findAll();
    }

    @Override
    public void save(TiempoCargo tiempoCargo) {
        tiempoCargoDao.save(tiempoCargo);
    }

    @Override
    public TiempoCargo findOne(Integer id) {
        return tiempoCargoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tiempoCargoDao.deleteById(id);
    }

}
