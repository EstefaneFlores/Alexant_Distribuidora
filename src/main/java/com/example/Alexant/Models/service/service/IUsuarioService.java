package com.example.Alexant.Models.service.service;

import java.util.List;

import com.example.Alexant.Models.entitys.Usuario;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario findOne(Integer id);

    public void delete(Integer id);

    public List<Usuario> getListarUsuariosActivos();

    public boolean verificarUsuario(String usuario, String clave);

    Usuario findByUsuarioAndContrasena(String usuario, String contrasena);
    
} 