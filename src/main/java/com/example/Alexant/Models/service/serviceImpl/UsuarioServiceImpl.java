package com.example.Alexant.Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alexant.Models.dao.IUsuarioDao;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) iUsuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        iUsuarioDao.save(usuario);
    }

    @Override
    public Usuario findOne(Integer id) {
        return iUsuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iUsuarioDao.deleteById(id);
    }

    @Override
    public List<Usuario> getListarUsuariosActivas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListarUsuariosActivas'");
    }
}
