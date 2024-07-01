package com.example.Alexant.Models.service.service;

import java.util.List;
 
import com.example.Alexant.Models.entitys.UsuarioRol;


public interface IUsuarioRolService {

    public List<UsuarioRol> findAll();

    public void save(UsuarioRol usuarioRol);

    public UsuarioRol findOne(Integer id);

    public void delete(Integer id);
    
    // List<UsuarioRol>listRolesUsuario(Usuario usuario);
}
