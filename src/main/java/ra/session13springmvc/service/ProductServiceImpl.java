package ra.session13springmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.session13springmvc.dao.IProductDao;
import ra.session13springmvc.model.dto.ProductRequest;
import ra.session13springmvc.model.entity.Image;
import ra.session13springmvc.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
    private final IProductDao productDao;
    private final UploadService uploadService;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void add(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        // upload file ảnh chính
        if (productRequest.getMainImage().getSize()>0){
            String imageMainUrl = uploadService.uploadFileToServer(productRequest.getMainImage());
            product.setImageUrl(imageMainUrl);
        }
        List<Image> subImageUrls = new ArrayList<>();
        // upload list ảnh phụ
        if (productRequest.getSubImage().size()>0){
            for (MultipartFile f : productRequest.getSubImage()){
                Image image = new Image(null,uploadService.uploadFileToServer(f));
                subImageUrls.add(image);
            }
        }
        product.setImageList(subImageUrls);

        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }
}
