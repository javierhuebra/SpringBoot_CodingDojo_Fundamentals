package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/humano")
public class HolaHumano {
    
    @RequestMapping("/humano") // La ruta es localhost:8080/humano?nombre=nombre
	public String index(@RequestParam(value = "nombre", required = true, defaultValue = "Humano") String searchQuery, @RequestParam(value = "apellido", required = true, defaultValue = "Bipedo!") String apellido ) {
	
	    return "Hola " + searchQuery + " " + apellido;
		
	}
}
