package deloof.wouter.recap_jee.controllers;

import deloof.wouter.recap_jee.model.Product;
import deloof.wouter.recap_jee.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute("products")
    public Iterable<Product> showAllProducts() {
        return dao.findAll();
    }

//    DISPLAY ALL PRODUCTS
    @RequestMapping( value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

//    LINK TO DETAIL PAGE
    @RequestMapping( value = "/detail/{id}", method = RequestMethod.GET)
    public String showDetail(ModelMap map, @PathVariable( name = "id") int id) {
        map.addAttribute( "productDetail", dao.findById(id).get() );
        return "details";
    }

}
