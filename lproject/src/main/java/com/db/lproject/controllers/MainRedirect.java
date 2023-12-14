package com.db.lproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainRedirect {
    @GetMapping("/")
    public String redirecionarParaOutraPagina() {
        return "redirect:/swagger-ui/index.html";
    }
}
