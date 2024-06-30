package com.example.Alexant.Models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Alexant.Models.entitys.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
    
    @Query("SELECT u FROM Usuario u WHERE u.estado_usuario = 'A'")
    List<Usuario> findUsuariosActivos();

    Usuario findByUsuarioAndContrasena(String usuario, String contrasena);
}
