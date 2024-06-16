package Models.service.service;

import java.util.List;

import Models.entitys.Detalle_lote;

public interface iDetalleLoteService {

    public List<Detalle_lote> findAll();

    public void save(Detalle_lote detalle_lote);

    public Detalle_lote findOne(Integer id);

    public void delete(Integer id);

} 