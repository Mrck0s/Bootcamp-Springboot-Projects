package com.marcos.encuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    private String name;
    private String location;
    private String language;
    private String comment;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/dashboard")
    public String getData(@ModelAttribute FormularioDatos formularioDatos){
        name = formularioDatos.getName();
        location = formularioDatos.getLocation();
        language = formularioDatos.getLanguage();
        comment = formularioDatos.getComment();

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("name", name);
        model.addAttribute("location", location);
        model.addAttribute("language", language);
        model.addAttribute("comment", comment);
        return "dashboard";
    }
}

