package Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import Models.dao.IUsuarioRolDao;
import Models.entitys.UsuarioRol;
import Models.service.service.IUsuarioRolService;

public class UsuarioRolServiceImpl implements IUsuarioRolService{
    @Autowired
    private IUsuarioRolDao iUsuarioRolDao;

    @Override
    public List<UsuarioRol> findAll() {
        return (List<UsuarioRol>) iUsuarioRolDao.findAll();
    }

    @Override
    public void save(UsuarioRol det_venta) {
        iUsuarioRolDao.save(det_venta);
    }

    @Override
    public UsuarioRol findOne(Integer id) {
        return iUsuarioRolDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iUsuarioRolDao.deleteById(id);
    }
}
