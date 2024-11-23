package com.sistemaescolar.sistemaescolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecretariaController {
    @GetMapping("/")    
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }
    @GetMapping("/Alunos")
    public ModelAndView Alunos(){
        ModelAndView mv = new ModelAndView("/Aluno/index.html");
        return mv;
    }
}
