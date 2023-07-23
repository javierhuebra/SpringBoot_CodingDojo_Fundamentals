package com.dojo.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerSession {
    int i = 0;//Arranca en cero
    @RequestMapping("/")
    String index(HttpSession session){
        i++;//En la primer request ya vale 1
        session.setAttribute("count", i);
        
        return "index";
    }

    @RequestMapping("/counter")
    String counter(HttpSession session, Model model){
        Integer count;

        //Validacion para que si entra primero a "/counter" marque cero ya que no se inicializó la sesion en "/" y no se ejecutó setAttribute aun
        if(session.getAttribute("count") != null){
            count = (Integer) session.getAttribute("count");
        }else{
            count = 0;
        }

        model.addAttribute("count", count);
        
        return "counter";
    }
}
