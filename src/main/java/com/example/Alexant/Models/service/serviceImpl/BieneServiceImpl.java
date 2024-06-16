package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IBieneDao;
import com.example.Alexant.Models.entitys.Biene;
import com.example.Alexant.Models.service.service.IBieneService;

@Service
public class BieneServiceImpl implements IBieneService {
    @Autowired
    private IBieneDao bieneDao;

    @Override
    public List<Biene> findAll() {
        return (List<Biene>) bieneDao.findAll();
    }

    @Override
    public void save(Biene biene) {
        bieneDao.save(biene);
    }

    @Override
    public Biene findOne(Integer id) {
        return bieneDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        bieneDao.deleteById(id);
    }
}
