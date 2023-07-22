package com.marcos.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadenasApplication.class, args);
        }
    @RequestMapping("/")
    public String welcome(){
        return "Welcome to my first Spring root directory";
    }
    @RequestMapping("/random")
    public String random(){
        return "This is a random route";
    }

}
