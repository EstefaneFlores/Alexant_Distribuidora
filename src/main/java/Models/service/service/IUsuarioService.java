package Models.service.service;

import java.util.List;

import Models.entitys.Usuario;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario findOne(Integer id);

    public void delete(Integer id);

    public List<Usuario> getListarUsuariosActivas();

    
} 