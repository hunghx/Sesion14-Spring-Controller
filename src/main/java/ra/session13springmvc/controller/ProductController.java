package ra.session13springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.session13springmvc.model.dto.ProductRequest;
import ra.session13springmvc.service.IProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService;
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("products",productService.getAll());
        return "list-product";
    }
    @RequestMapping("/add")
    public  String add(){
        return "add-product";
    }
    @RequestMapping("/detail/{id}")
    public  String details(@PathVariable Integer id ,Model  model){
        model.addAttribute("pro",productService.findById(id));
        return "detail-product";
    }
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public  String doAdd(@ModelAttribute ProductRequest productRequest){
        productService.add(productRequest);
        return "redirect:/product/list";
    }
}
