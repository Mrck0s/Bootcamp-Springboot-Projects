package com.marcos.contador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;

@Controller
public class CounterController {
    public Integer counter = 0;

    @GetMapping("/")
    public String index(HttpSession session) {
        counter++;
        session.setAttribute("counter", counter);
        return "index";
    }

    @GetMapping("/counter")
    public String showCounterPage(HttpSession session, Model model) {
        //Muestra el contador
        counter = (Integer) session.getAttribute("counter");
        model.addAttribute("counter", counter);
        return "counter";
    }

    @GetMapping("/reset")
    public String resetCounter(HttpSession session, Model model) {
        // Reiniciar el contador a 0
        counter = 0;
        session.setAttribute("counter", counter);
        model.addAttribute("counter", counter);
        return "reset";
    }
}
