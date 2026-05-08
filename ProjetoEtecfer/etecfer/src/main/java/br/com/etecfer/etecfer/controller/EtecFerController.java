package br.com.etecfer.etecfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/ProjetoEtecfer")
public class EtecFerController {
    
    @GetMapping
    public String index(Model model){
        return"index";
    }
    
}
