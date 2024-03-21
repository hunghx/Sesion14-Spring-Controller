package ra.session13springmvc.service;

import ra.session13springmvc.model.dto.ProductRequest;
import ra.session13springmvc.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(ProductRequest productRequest);
    Product findById(Integer id);
}
