package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Responsavel;

import com.sistemaescolar.sistemaescolar.service.ResponsavelService;


@Controller
@RequestMapping("/responsaveis")
public class ResponsavelController implements IControladores<Responsavel,String> {

    private ResponsavelService rs;

    public ResponsavelController(ResponsavelService rs){
        this.rs = rs;

    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("responsaveis/novo.html");
        mv.addObject("responsavel", new Responsavel() );
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Responsavel obj) {
        obj = rs.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/responsaveis");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("responsaveis/index.html");
        mv.addObject("responsaveis", rs.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("responsaveis/editar.html");
        mv.addObject("responsavel", rs.busca(chave));
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Responsavel obj, String cpf) {
        ModelAndView mv  = new ModelAndView("redirect:/responsaveis");
        obj = rs.atualizar(obj);
        return mv;
    }
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Responsavel> responsavel = rs.busca(chave);
        ModelAndView mv;
        if (responsavel.isPresent()){       
            mv = new ModelAndView("responsaveis/excluir.html");
            mv.addObject("responsavel", responsavel);
        }
        else{
            mv = new ModelAndView("redirect:/responsaveis");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Responsavel obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/responsaveis");
        rs.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    @GetMapping("/voltarNovo")
    public ModelAndView voltarNovo(){
        ModelAndView mv = new ModelAndView("redirect:../responsaveis");
        return mv;
    }
    
}
