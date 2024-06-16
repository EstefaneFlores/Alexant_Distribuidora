package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IEmpleadoDao;
import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.service.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public void save(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    public Empleado findOne(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        empleadoDao.deleteById(id);
    }
     
}
