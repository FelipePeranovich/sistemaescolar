package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Turma;
import com.sistemaescolar.sistemaescolar.service.TurmaService;

@Controller
@RequestMapping("/turmas")
public class TurmaController implements IControladores<Turma, String> {

    private TurmaService ts;

    public TurmaController(TurmaService ts){
        this.ts = ts;
    }

     @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("turmas/novo.html");
        mv.addObject("turma", new Turma());
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Turma obj) {
        obj = ts.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/turmas");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("turmas/index.html");
        mv.addObject("turma", ts.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("turmas/editar.html");
        mv.addObject("turma", ts.busca(chave));
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Turma obj, String cpf) {
        ModelAndView mv  = new ModelAndView("redirect:/turmas");
        obj = ts.atualizar(obj);
        return mv;
    }

    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Turma> turma = ts.busca(chave);
        ModelAndView mv;
        if (turma.isPresent()){       
            mv = new ModelAndView("turmas/excluir.html");
            mv.addObject("turma", turma);
        }
        else{
            mv = new ModelAndView("redirect:/turmas");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Turma obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/turmas");
        ts.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    @GetMapping("/voltarNovo")
    public ModelAndView voltarNovo(){
        ModelAndView mv = new ModelAndView("redirect:../turmas");
        return mv;
    }
    @GetMapping("editar/voltarEditar")
    public ModelAndView voltarEditar(){
        ModelAndView mv = new ModelAndView("redirect:../../turmas");
        return mv;
    }
    @GetMapping("detalhar/voltarDetalhar")
    public ModelAndView voltarDetalhar(){
        ModelAndView mv = new ModelAndView("redirect:../../turmas");
        return mv;
    }
    @GetMapping("detalhar/{chave}")
	@Override
	public ModelAndView detalhar(@PathVariable String chave) {
		ModelAndView mv = new ModelAndView("turmas/detalhar.html");
        mv.addObject("turma", ts.busca(chave));
        return mv;
	}
    
}
