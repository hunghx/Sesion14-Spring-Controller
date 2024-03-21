package ra.session13springmvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private String name;
    private MultipartFile mainImage;
    private String description;
    private BigDecimal price;
    private List<MultipartFile> subImage;
}
