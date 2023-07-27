package com.marcos.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/checkCode")
    public String checkCode(@RequestParam("code") String code) {
        if ("bushido".equals(code)) {
            return "redirect:/code";
        } else {
            return "redirect:/?error=true";
        }
    }

    @GetMapping("/code")
    public String theCode() {
        return "thecode";
    }
}
