package com.dojo.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerPost {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String user,
            @RequestParam(value = "password") String password, RedirectAttributes atributo) {

        System.out.println("Usuario: " + user + " Contraseña: " + password);

        if (user.length() == 0 || password.length() == 0) {
            atributo.addFlashAttribute("error", "Debe llenar los campos!!!");
            
            return "redirect:/login";
        } else {
            atributo.addFlashAttribute("mensaje",
                    "Solicitud POST exitosa! Este mensaje flash se genera en el metodo login(user,password) cuando se efectua la solicitud de tipo POST "
                            + "Usuario: " + user + " Contraseña: " + password);

            return "redirect:/enviado";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logins() {
        return "login";
    }

    // La solicitud POST de la linea 10 retorna una redirección que me deja en
    // /enviado mas si no hay controlador con solicitud GET no muestra la pagina
    @RequestMapping("/enviado")
    public String enviado() {
        return "enviado";
    }
}
