package Models.service.service;

import java.util.List;

import Models.entitys.Factura;

public interface IFacturaService {
    
    public List<Factura> findAll();

    public void save(Factura biene);

    public Factura findOne(Integer id);

    public void delete(Integer id);


}
