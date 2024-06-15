package Models.service.service;

import java.util.List;

import Models.entitys.Moneda;

public interface IMonedaService {

    public List<Moneda> findAll();

    public void save(Moneda moneda);

    public Moneda findOne(Integer id);

    public void delete(Integer id);

  
}
