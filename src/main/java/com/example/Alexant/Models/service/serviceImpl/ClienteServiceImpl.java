package com.example.Alexant.Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IClienteDao;
import com.example.Alexant.Models.entitys.Cliente;
import com.example.Alexant.Models.service.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteDao iClienteDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    public Cliente findOne(Integer id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iClienteDao.deleteById(id);
    }

}
