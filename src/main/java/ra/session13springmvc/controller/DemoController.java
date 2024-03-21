package ra.session13springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ra.session13springmvc.model.dto.FormRequest;

@Controller
public class DemoController {
    @RequestMapping("/hello/{uri}/add/{id}")  // /hello/hello-world/add/1
    public String hello(Model model, @PathVariable(name = "uri") Integer uri, @PathVariable(name = "id") String id) {
        model.addAttribute("uri", uri);
        model.addAttribute("id", id);
        return "hello";
    }

    @RequestMapping("/hi/{regex:[0-9]{3}}")  // /hello/hello-world/add/1
    public String hi(Model model, @PathVariable(name = "regex") String regex) {
        model.addAttribute("uri", regex);
        return "hello";
    }


    // RequestParam
    @RequestMapping("/form")
    public String doGet(@RequestParam String id, @RequestParam String name, ModelMap map){
        map.addAttribute("id",id);
        map.addAttribute("name",name);
        return "hi";
    }
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String doPost(@RequestParam String id, @RequestParam String name, ModelMap map){
        map.addAttribute("id",id);
        map.addAttribute("name",name);
        return "hi";
    }
    @RequestMapping(value = "/form-object",method = RequestMethod.POST)
    public String doPostObject(@ModelAttribute FormRequest formRequest, ModelMap map){
        map.addAttribute("id",formRequest.getId());
        map.addAttribute("name",formRequest.getName());
        return "hi";
    }




}
