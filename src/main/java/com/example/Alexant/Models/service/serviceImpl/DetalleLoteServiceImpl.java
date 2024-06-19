package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IDetalle_loteDao;
import com.example.Alexant.Models.entitys.Detalle_lote;
import com.example.Alexant.Models.service.service.IDetalleLoteServicee;

@Service
public class DetalleLoteServiceImpl implements IDetalleLoteServicee{
    @Autowired
    private IDetalle_loteDao detalle_loteDao;

    @Override
    public List<Detalle_lote> findAll() {
        return (List<Detalle_lote>) detalle_loteDao.findAll();
    }

    @Override
    public void save(Detalle_lote detalle_lote) {
        detalle_loteDao.save(detalle_lote);
    }

    @Override
    public Detalle_lote findOne(Integer id) {
        return detalle_loteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        detalle_loteDao.deleteById(id);
    }
}
