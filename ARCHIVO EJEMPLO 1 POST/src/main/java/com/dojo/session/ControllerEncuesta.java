package com.dojo.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/encuesta")
public class ControllerEncuesta {

    // Solicitud GET para renderizar la view
    @RequestMapping("")
    public String renderEncuesta() {
        return "encuesta/encuesta";
    }

    @RequestMapping("/tieneJava")
    public String renderTieneJava( HttpSession sesion, Model model) {
        model.addAttribute("nombre", sesion.getAttribute("nombre"));
        model.addAttribute("ubicacion", sesion.getAttribute("ubicacion"));
        model.addAttribute("lenguaje", sesion.getAttribute("lenguaje"));
        model.addAttribute("comentario", sesion.getAttribute("comentario"));
        return "encuesta/tieneJava";
    }

    // Solicitud GET para renderizar view resultado
    @RequestMapping("/result")
    public String renderResultado( HttpSession sesion, Model model) {
        model.addAttribute("nombre", sesion.getAttribute("nombre"));
        model.addAttribute("ubicacion", sesion.getAttribute("ubicacion"));
        model.addAttribute("lenguaje", sesion.getAttribute("lenguaje"));
        model.addAttribute("comentario", sesion.getAttribute("comentario"));
        return "encuesta/result";
    }

    // Solicitud POST para enviar datos a la ruta /encuesta
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String enviarDatos(HttpSession sesion,
            @RequestParam(value = "nombre") String nombre,//Cargarlo en la sesion
            @RequestParam(value = "ubicacion") String ubicacion,
            @RequestParam(value = "lenguaje") String lenguaje,
            @RequestParam(value = "comentario") String comentario
            /* Model model */ // Hay que meter un modelo para poder pasar los datos a la view con thymeleaf
    ) {
        
        sesion.setAttribute("nombre", nombre);
        sesion.setAttribute("ubicacion", ubicacion);
        sesion.setAttribute("lenguaje", lenguaje);
        sesion.setAttribute("comentario", comentario);

        if(lenguaje.equals("java")){
            return "redirect:/encuesta/tieneJava";//Si retorno algo con redirect:/ no le puedo mandar datos con addAtribute y modelo no se por que
        }else{                          //Seguro debe ser que se renderiza la vista cuando se la invoca y puede imprimer los datos cargados con addatribute
            return "redirect:/encuesta/result";   //Si se hace una redirección no
        }
        
        /* System.out.println(nombre); Esto era para debuggear porque habia retornado redirect:/encuesta/result y no me tomaba el tema de model la view
        System.out.println("Valor del atributo 'nombre': " + model.getAttribute("nombre"));
        System.out.println("Valor del atributo 'variable': " + model.getAttribute("variable")); */

        
    }
}
