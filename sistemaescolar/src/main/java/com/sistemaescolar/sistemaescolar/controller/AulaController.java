package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Aula;
import com.sistemaescolar.sistemaescolar.service.AulaService;


@Controller
@RequestMapping("/aulas")
public class AulaController implements IControladores<Aula,String> {

    private AulaService as;

    public AulaController(AulaService as){
        this.as = as;
    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("aulas/novo.html");
        mv.addObject("aula", new Aula() );
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Aula obj) {
        obj = as.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/aulas");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("aulas/index.html");
        mv.addObject("aulas", as.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("aulas/editar.html");
        mv.addObject("aula", as.busca(chave));
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Aula obj, String codAula) {
        ModelAndView mv  = new ModelAndView("redirect:/aulas");
        obj = as.atualizar(obj);
        return mv;
    }
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Aula> aula = as.busca(chave);
        ModelAndView mv;
        if (aula.isPresent()){       
            mv = new ModelAndView("aulas/excluir.html");
            mv.addObject("aula", aula);
        }
        else{
            mv = new ModelAndView("redirect:/aulas");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Aula obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/aulas");
        as.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

	@Override
	public ModelAndView detalhar(String chave) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'detalhar'");
	}

    
}
