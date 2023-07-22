package com.marcos.holahumano;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public String saludar(@RequestParam(name = "nombre", required = false) String nombre,
                          @RequestParam(name = "apellido", required = false) String apellido) {
        if (nombre == null || nombre.isEmpty()) {
            nombre = "Humano";
        }

        if (apellido == null || apellido.isEmpty()) {
            return "Hola, " + nombre + "!";
        } else {
            return "Hola, " + nombre + " " + apellido + "!";
        }
    }
}
