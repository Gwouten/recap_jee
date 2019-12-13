package deloof.wouter.recap_jee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewController {

    @RequestMapping( value = "/new", method = RequestMethod.POST)
    public String showNew() {
        return "new";
    }

}
