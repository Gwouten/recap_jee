package deloof.wouter.recap_jee.controllers;

import deloof.wouter.recap_jee.model.Product;
import deloof.wouter.recap_jee.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AddController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute("newProduct")
    public Product addNewProduct() {
        return new Product();
    }

    //Ga naar âgina en maak een lege modelmap aan om de gegevens uit bovenstaande modelAttribute te halen
    @RequestMapping( value = "/new", method = RequestMethod.GET)
    public String showNew(ModelMap map) {
        return "new";
    }

    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public String saveNew(@ModelAttribute("newProduct") @Valid Product product, BindingResult br) {
        System.out.println(br);
        if(br.hasErrors()){
            return "new";
        }
        dao.save(product);
        return "redirect:/index";
    }
}
