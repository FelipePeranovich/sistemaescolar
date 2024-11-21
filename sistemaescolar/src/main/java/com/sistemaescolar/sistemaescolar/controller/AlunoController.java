package com.sistemaescolar.sistemaescolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Aluno;
import com.sistemaescolar.sistemaescolar.service.AlunoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/alunos")
public class AlunoController implements IControladores<Aluno,String> {

    private AlunoService as;

    public AlunoController(AlunoService as){
        this.as = as;
    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("alunos/novo.html");
        mv.addObject("aluno", new Aluno() );
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Aluno obj) {
        obj = as.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/");
      return mv;
    }
    /* 
    @GetMapping
    @Override
    public ModelAndView listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar(Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Object obj, Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Object obj, Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
    */
}
