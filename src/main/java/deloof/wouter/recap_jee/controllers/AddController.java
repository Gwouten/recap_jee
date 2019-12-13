package deloof.wouter.recap_jee.controllers;

import deloof.wouter.recap_jee.model.Product;
import deloof.wouter.recap_jee.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AddController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute("nProduct")
    public Product addNewProduct() {
        return new Product();
    }

    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public String showNew(@ModelAttribute(name = "nProduct") @Valid Product product, BindingResult br) {
        dao.save(product);
        return "redirect:/index";
    }

}
