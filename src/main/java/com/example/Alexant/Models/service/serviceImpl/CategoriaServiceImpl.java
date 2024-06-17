package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.ICategoriaDao;
import com.example.Alexant.Models.entitys.Categoria;
import com.example.Alexant.Models.service.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
    @Autowired
    private ICategoriaDao iCategoriaDao;

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) iCategoriaDao.findAll();
    }

    @Override
    public void save(Categoria categoria) {
        iCategoriaDao.save(categoria);
    }

    @Override
    public Categoria findOne(Integer id) {
        return iCategoriaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iCategoriaDao.deleteById(id);
    }

}
