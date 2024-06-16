package Models.service.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.dao.IDetalle_loteDao;
import Models.entitys.Detalle_lote;
import Models.service.service.iDetalleLoteService;

@Service
public class DetalleLoteServiceImpl implements iDetalleLoteService{
    @Autowired
    private IDetalle_loteDao detalle_loteDao;

    @Override
    public List<Detalle_lote> findAll() {
        return (List<Detalle_lote>) detalle_loteDao.findAll();
    }

    @Override
    public void save(Detalle_lote detalle_lote) {
        detalle_loteDao.save(detalle_lote);
    }

    @Override
    public Detalle_lote findOne(Integer id) {
        return detalle_loteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        detalle_loteDao.deleteById(id);
    }
}
