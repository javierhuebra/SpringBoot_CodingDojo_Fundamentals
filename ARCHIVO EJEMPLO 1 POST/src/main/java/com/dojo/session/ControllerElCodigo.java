package com.dojo.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/elcodigo")
public class ControllerElCodigo {
    
    @RequestMapping("")
    public String renderCodigo(){
        return "viewprueba/elcodigo";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String recibirCodigo(@RequestParam(value = "code") String code, RedirectAttributes atributo){
        System.out.println(code);//Tengo el formulario html conectado con method y action

        if(code.equals("bushido")){
            return "redirect:/elcodigo/code";
        }else{
            atributo.addFlashAttribute("error", "El codigo ingresado no es el esperado!");
            return "redirect:/elcodigo";//Redirecciona a la ruta, no hay que poner viewpreba porque esa es la referencia del archivo en la app
        }  
    }

    @RequestMapping("/code")
    public String renderCode(){
        return "viewprueba/code";
    }
}
