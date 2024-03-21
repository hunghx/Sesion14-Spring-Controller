package ra.session13springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session13springmvc.dao.IDao;
import ra.session13springmvc.model.entity.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DaoService implements IDaoService{
    @Autowired
    private IDao daodao ;
    @Override
    public List<Dao> getAll() {
        return daodao.getAll();
    }

    @Override
    public Dao getById(Integer id) {
        return daodao.getById(id);
    }

    @Override
    public void save(Dao dao) {
        daodao.save(dao);
    }

    @Override
    public void delete(Integer id) {
        daodao.delete(id);
    }
}
