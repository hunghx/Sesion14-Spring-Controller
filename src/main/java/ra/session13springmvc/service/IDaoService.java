package ra.session13springmvc.service;

import ra.session13springmvc.model.entity.Dao;

import java.util.List;

public interface IDaoService {

    List<Dao> getAll();
    Dao getById(Integer id);
    void save(Dao dao);
    void delete(Integer id);
}
