package Models.service.service;

import java.util.List;

import Models.entitys.TipoCambio;


public interface ITipoCambioService {

     public List<TipoCambio> findAll();

    public void save(TipoCambio tipo_Biene);

    public TipoCambio findOne(Integer id);

    public void delete(Integer id);
    
} 
