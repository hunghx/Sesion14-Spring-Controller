package ra.session13springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.session13springmvc.model.entity.Dao;
import ra.session13springmvc.service.IDaoService;

@Controller
@RequestMapping("/dao")
public class DaoController {
    @Autowired
    private IDaoService daoService;
    // chuyển hương sang form add
    @RequestMapping("/add") // GET
    public String add(){
        return "add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String doAdd(@ModelAttribute Dao dao){
        daoService.save(dao);
        return "redirect:/";
    }
    // edit
    @RequestMapping("/edit/{id}") // GET
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("dao",daoService.getById(id));
        return "edit";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String doUpdate(@ModelAttribute Dao dao){
        daoService.save(dao);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
       daoService.delete(id);
        return "redirect:/";
    }
}
