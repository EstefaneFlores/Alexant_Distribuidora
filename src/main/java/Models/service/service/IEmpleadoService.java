package Models.service.service;

import java.util.List;

import Models.entitys.Empleado;

public interface IEmpleadoService {
public List<Empleado> findAll();

    public void save(Empleado empleado);

    public Empleado findOne(Integer id);

    public void delete(Integer id);
    
} 