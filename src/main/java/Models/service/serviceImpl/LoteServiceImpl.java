package Models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.ILoteDao;
import Models.entitys.Lote;
import Models.service.service.ILoteService;

@Service
public class LoteServiceImpl implements ILoteService{
    @Autowired
    private ILoteDao iLoteDao;

    @Override
    public List<Lote> findAll() {
        return (List<Lote>) iLoteDao.findAll();
    }

    @Override
    public void save(Lote lote) {
        iLoteDao.save(lote);
    }

    @Override
    public Lote findOne(Integer id) {
        return iLoteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iLoteDao.deleteById(id);
    }

}
