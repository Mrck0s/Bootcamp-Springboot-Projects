package com.marcos.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {

    @RequestMapping("/coding")
    public String sayHello() {
        return "¡Hola Coding Dojo!";
    }

    @RequestMapping("/coding/python")
    public String pythonMessage() {
        return "¡Python/Django fue increíble!";
    }

    @RequestMapping("/coding/java")
    public String javaMessage() {
        return "¡Java/Spring es mejor!";
    }
}
