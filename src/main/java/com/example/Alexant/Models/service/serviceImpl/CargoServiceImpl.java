package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.ICargoDao;
import com.example.Alexant.Models.entitys.Cargo;
import com.example.Alexant.Models.service.service.ICargoService;

@Service
public class CargoServiceImpl implements ICargoService{
    @Autowired
    private ICargoDao iCargoDao;

    @Override
    public List<Cargo> findAll() {
        return (List<Cargo>) iCargoDao.findAll();
    }

    @Override
    public void save(Cargo cargo) {
        iCargoDao.save(cargo);
    }

    @Override
    public Cargo findOne(Integer id) {
        return iCargoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iCargoDao.deleteById(id);
    }

}
