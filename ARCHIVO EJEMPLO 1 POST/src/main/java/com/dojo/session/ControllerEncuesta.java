package com.dojo.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/encuesta")
public class ControllerEncuesta {

    // Solicitud GET para renderizar la view
    @RequestMapping("")
    public String renderEncuesta() {
        return "encuesta/encuesta";
    }

    // Solicitud GET para renderizar view resultado
    @RequestMapping("/result")
    public String renderResultado() {

        return "encuesta/result";
    }

    // Solicitud POST para enviar datos a la ruta /encuesta
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String enviarDatos(
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "ubicacion") String ubicacion,
            @RequestParam(value = "lenguaje") String lenguaje,
            @RequestParam(value = "comentario") String comentario,
            Model model // Hay que meter un modelo para poder pasar los datos a la view con thymeleaf
    ) {
        
        model.addAttribute("nombre", nombre);
        model.addAttribute("ubicacion", ubicacion);
        model.addAttribute("lenguaje", lenguaje);
        model.addAttribute("comentario", comentario);

        if(lenguaje.equals("java")){
            return "encuesta/tieneJava";
        }else{
            return "encuesta/result";
        }
        
        /* System.out.println(nombre); Esto era para debuggear porque habia retornado redirect:/encuesta/result y no me tomaba el tema de model la view
        System.out.println("Valor del atributo 'nombre': " + model.getAttribute("nombre"));
        System.out.println("Valor del atributo 'variable': " + model.getAttribute("variable")); */

        
    }
}
