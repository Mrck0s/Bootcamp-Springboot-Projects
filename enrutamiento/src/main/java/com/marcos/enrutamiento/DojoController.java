package com.marcos.enrutamiento;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

    @RequestMapping("/{dojoName}")
    public String dojoMessage(@PathVariable String dojoName) {
        if (dojoName.equals("dojo")) {
            return "¡El Dojo es increíble!";
        } else if (dojoName.equals("burbank-dojo")) {
            return "El Dojo Burbank está localizado al sur de California";
        } else if (dojoName.equals("san-jose")) {
            return "El Dojo SJ es el cuartel general";
        } else {
            return "Dojo no encontrado";
        }
    }
}