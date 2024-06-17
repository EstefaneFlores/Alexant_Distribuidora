package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IUsuarioRolDao;
import com.example.Alexant.Models.entitys.UsuarioRol;
import com.example.Alexant.Models.service.service.IUsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolService{
    @Autowired
    private IUsuarioRolDao iUsuarioRolDao;

    @Override
    public List<UsuarioRol> findAll() {
        return (List<UsuarioRol>) iUsuarioRolDao.findAll();
    }

    @Override
    public void save(UsuarioRol det_venta) {
        iUsuarioRolDao.save(det_venta);
    }

    @Override
    public UsuarioRol findOne(Integer id) {
        return iUsuarioRolDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iUsuarioRolDao.deleteById(id);
    }
}
