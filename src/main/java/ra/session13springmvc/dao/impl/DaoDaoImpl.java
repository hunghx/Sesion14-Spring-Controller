package ra.session13springmvc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.session13springmvc.dao.IDao;
import ra.session13springmvc.model.entity.Dao;

import java.util.List;
@Component
public class DaoDaoImpl implements IDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Dao> getAll() {
        return jdbcTemplate.query("select * from dao"
                ,new BeanPropertyRowMapper<>(Dao.class));
    }

    @Override
    public Dao getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from dao where id = ?"
                ,new Object[]{id},new BeanPropertyRowMapper<>(Dao.class));
    }

    @Override
    public void save(Dao dao) {
        String sql ;
        if (dao.getId()==null){
            sql = "insert into dao(name, height, weight, birthday, price)  value (?,?,?,?,?)";
            jdbcTemplate.update(sql,dao.getName(),dao.getHeight(),dao.getWeight(),dao.getBirthday(),dao.getPrice());
        }else {
            sql = "update dao set name= ? , height=? ,weight=? ,birthday=?, price = ? where id = ?";
            jdbcTemplate.update(sql,dao.getName(),dao.getHeight(),dao.getWeight(),dao.getBirthday(),dao.getPrice(),dao.getId());

        }
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from dao where  id = ?",id);
    }
}
