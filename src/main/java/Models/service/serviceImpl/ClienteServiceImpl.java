package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IClienteDao;
import Models.entitys.Cliente;
import Models.service.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteDao iClienteDao;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    public Cliente findOne(Integer id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iClienteDao.deleteById(id);
    }

}
