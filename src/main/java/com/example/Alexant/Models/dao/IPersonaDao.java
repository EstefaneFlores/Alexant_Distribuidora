package com.example.Alexant.Models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    
   @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD') LIMIT 1", nativeQuery = true)
    Persona buscarPorCi(String ci);

}
