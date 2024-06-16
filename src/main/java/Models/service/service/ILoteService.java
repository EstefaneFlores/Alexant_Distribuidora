package Models.service.service;

import java.util.List;

import Models.entitys.Lote;

public interface ILoteService {
    
    public List<Lote> findAll();

    public void save(Lote lote);

    public Lote findOne(Integer id);

    public void delete(Integer id);


}
