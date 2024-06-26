package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.ITipo_CambioDao;
import com.example.Alexant.Models.entitys.TipoCambio;
import com.example.Alexant.Models.service.service.ITipoCambioService;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService{
    @Autowired
    private ITipo_CambioDao iTipo_CambioDao;

    @Override
    public List<TipoCambio> findAll() {
        return (List<TipoCambio>) iTipo_CambioDao.findAll();
    }

    @Override
    public void save(TipoCambio tipoCambio) {
        iTipo_CambioDao.save(tipoCambio);
    }

    @Override
    public TipoCambio findOne(Integer id) {
        return iTipo_CambioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iTipo_CambioDao.deleteById(id);
    }

}
