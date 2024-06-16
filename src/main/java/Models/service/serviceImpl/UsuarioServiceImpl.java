package Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IUsuarioDao;
import Models.entitys.Usuario;
import Models.service.service.IUsuarioService;

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
