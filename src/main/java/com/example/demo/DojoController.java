package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/dojo")
public class DojoController {
    
    @GetMapping("/dojo/{nombre}")
    public String saludarDojo(@PathVariable String nombre) {
        return "¡El Dojo, " + nombre + " es increíble!";
    }

    @RequestMapping("/burbank-dojo")
    public String dojoBuruBank() {
        return "¡El dojo Bur Bank esta localizado al sur de California!";
    }

    @RequestMapping("/san-jose")
    public String dojoSanJose() {
        return "¡El Dojo San José es genial!";
    }
}
