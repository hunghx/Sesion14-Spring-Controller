package ra.session13springmvc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dao {
    private Integer id;
    private String name;
    private double height, weight;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private double price;
}
