package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Aluno;
import com.sistemaescolar.sistemaescolar.service.AlunoService;
import com.sistemaescolar.sistemaescolar.service.TurmaService;


@Controller
@RequestMapping("/alunos")
public class AlunoController implements IControladores<Aluno,String> {

    private AlunoService as;

    private TurmaService ts;

    public AlunoController(AlunoService as, TurmaService ts){
        this.as = as;
        this.ts = ts;
    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("alunos/novo.html");
        mv.addObject("aluno", new Aluno() );
        mv.addObject("turma", ts.todos());
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Aluno obj) {
        obj = as.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/alunos");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("alunos/index.html");
        mv.addObject("alunos", as.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("alunos/editar.html");
        mv.addObject("aluno", as.busca(chave));
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Aluno obj, String Ra) {
        ModelAndView mv  = new ModelAndView("redirect:/alunos");
        obj = as.atualizar(obj);
        return mv;
    }
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Aluno> aluno = as.busca(chave);
        ModelAndView mv;
        if (aluno.isPresent()){       
            mv = new ModelAndView("alunos/excluir.html");
            mv.addObject("aluno", aluno);
        }
        else{
            mv = new ModelAndView("redirect:/alunos");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Aluno obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/alunos");
        as.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    @GetMapping("/voltarNovo")
    public ModelAndView voltarNovo(){
        ModelAndView mv = new ModelAndView("redirect:../alunos");
        return mv;
    }
    
}
