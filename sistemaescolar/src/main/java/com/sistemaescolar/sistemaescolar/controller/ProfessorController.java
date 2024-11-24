package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Professor;

import com.sistemaescolar.sistemaescolar.service.ProfessorService;


@Controller
@RequestMapping("/professores")
public class ProfessorController implements IControladores<Professor,String> {

    private ProfessorService ps;

    public ProfessorController(ProfessorService ps){
        this.ps = ps;

    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("professores/novo.html");
        mv.addObject("professor", new Professor() );
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Professor obj) {
        obj = ps.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/professores");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("professores/index.html");
        mv.addObject("professores", ps.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("professores/editar.html");
        mv.addObject("professor", ps.busca(chave));
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Professor obj, String cpf) {
        ModelAndView mv  = new ModelAndView("redirect:/alunos");
        obj = ps.atualizar(obj);
        return mv;
    }
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Professor> professor = ps.busca(chave);
        ModelAndView mv;
        if (professor.isPresent()){       
            mv = new ModelAndView("professores/excluir.html");
            mv.addObject("professor", professor);
        }
        else{
            mv = new ModelAndView("redirect:/professores");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Professor obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/professores");
        ps.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    @GetMapping("/voltarNovo")
    public ModelAndView voltarNovo(){
        ModelAndView mv = new ModelAndView("redirect:../professores");
        return mv;
    }

	@Override
	public ModelAndView detalhar(String chave) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'detalhar'");
	}
    
}
