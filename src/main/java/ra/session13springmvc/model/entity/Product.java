package ra.session13springmvc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Integer id;
    private String name,description,imageUrl;
    private BigDecimal price;
    private boolean status;
    private List<Image> imageList;
}
