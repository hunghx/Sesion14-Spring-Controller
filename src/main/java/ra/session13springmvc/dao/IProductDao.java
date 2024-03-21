package ra.session13springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.session13springmvc.model.entity.Product;

import java.util.List;


public interface IProductDao {
    List<Product> getAll();
    Product findById(Integer id);
    void save(Product product);
    void delete(Integer id);
}
