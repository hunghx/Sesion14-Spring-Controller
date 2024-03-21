package ra.session13springmvc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import ra.session13springmvc.dao.IProductDao;
import ra.session13springmvc.model.entity.Image;
import ra.session13springmvc.model.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoImpl implements IProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        List<Product> products = jdbcTemplate.query("select * from product",(rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getBigDecimal("price"));
            p.setImageUrl(rs.getString("imageUrl"));
            p.setStatus(rs.getBoolean("status"));
            return p;
        });
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Product product = jdbcTemplate.queryForObject("select * from product where id = ?",new Object[]{id
        },(rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getBigDecimal("price"));
            p.setImageUrl(rs.getString("imageUrl"));
            p.setStatus(rs.getBoolean("status"));
            return p;
        });
        if (product!=null) {
            List<Image> images = jdbcTemplate.query("select * from productImage where product_id =?", new Object[]{id},
                    (rs, rowNum) -> {
                        Image image = new Image();
                        image.setId(rs.getInt("id"));
                        image.setUrl(rs.getString("img_url"));
                        return image;
                    });
            product.setImageList(images);
        }
        return product;
    }


    @Override
    public void save(Product product) {
        if (product.getId()==null){
            GeneratedKeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement statement = con.prepareStatement("insert into product(name, description, price, imageUrl) value (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, product.getName());
                statement.setString(2, product.getDescription());
                statement.setBigDecimal(3, product.getPrice());
                statement.setString(4, product.getImageUrl());
                return statement;
            }, holder);

            long primaryKey = holder.getKey().longValue();

//            thêm mới
            // taooj sp

          if (primaryKey!=0){

              StringBuilder insertImage = new StringBuilder("insert into productimage(product_id, img_url) values ");
              for (int i = 0; i < product.getImageList().size(); i++) {
                  Image img = product.getImageList().get(i);
                  insertImage.append("(").append(primaryKey).append(",'").append(img.getUrl()).append("')");
                  if (i < product.getImageList().size()-1){
                      insertImage.append(",");
                  }
              }

              jdbcTemplate.update(insertImage.toString());
          }

        }
    }

    @Override
    public void delete(Integer id) {

    }
}
