package com.sistemaescolar.sistemaescolar.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistemaescolar.sistemaescolar.interfaces.IControladores;
import com.sistemaescolar.sistemaescolar.models.Materia;
import com.sistemaescolar.sistemaescolar.service.MateriaService;
import com.sistemaescolar.sistemaescolar.service.ProfessorService;


@Controller
@RequestMapping("/materias")
public class MateriaController implements IControladores<Materia,String> {

    private MateriaService ms;
    private ProfessorService ps;
    public MateriaController(MateriaService ms, ProfessorService ps){
        this.ms = ms;
        this.ps = ps;
    }
    
    @GetMapping("/novo")
    @Override
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("materias/novo.html");
        mv.addObject("materia", new Materia() );
        mv.addObject("professor", ps.todos());
        return mv;
    }
    @PostMapping("/novo")   
    @Override
    public ModelAndView novo(Materia obj) {
        obj = ms.novo(obj);
      ModelAndView mv = new ModelAndView("redirect:/materias");
      return mv;
    }
    
    @GetMapping
    @Override
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("materias/index.html");
        mv.addObject("materias", ms.todos());
        return mv;
    }
    
    @GetMapping("/editar/{chave}")
    @Override
    public ModelAndView editar( @PathVariable String chave) {
        ModelAndView mv = new ModelAndView("materias/editar.html");
        mv.addObject("materia", ms.busca(chave));
        mv.addObject("professor", ps.todos());
        return mv;
    }
    @PostMapping("/editar")
    @Override
    public ModelAndView editar(Materia obj, String codMateria) {
        ModelAndView mv  = new ModelAndView("redirect:/materias");
        obj = ms.atualizar(obj);
        return mv;
    }
    
    @GetMapping("/excluir/{chave}")
    @Override
    public ModelAndView excluir(@PathVariable String chave) {
        Optional<Materia> materia = ms.busca(chave);
        ModelAndView mv;
        if (materia.isPresent()){       
            mv = new ModelAndView("materias/excluir.html");
            mv.addObject("materia", materia);
        }
        else{
            mv = new ModelAndView("redirect:/materias");
        }
        return mv;
    }

    @PostMapping("/excluir")
    @Override
    public ModelAndView excluir(Materia obj, String chave) {
        ModelAndView mv  = new ModelAndView("redirect:/materias");
        ms.excluir(obj);
        return mv;
    }
    @GetMapping("/voltar")
    public ModelAndView voltar(){
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
    @GetMapping("/voltarNovo")
    public ModelAndView voltarNovo(){
        ModelAndView mv = new ModelAndView("redirect:../materias");
        return mv;
    }
    @GetMapping("editar/voltarEditar")
    public ModelAndView voltarEditar(){
        ModelAndView mv = new ModelAndView("redirect:../../materias");
        return mv;
    }
    @GetMapping("detalhar/voltarDetalhar")
    public ModelAndView voltarDetalhar(){
        ModelAndView mv = new ModelAndView("redirect:../../materias");
        return mv;
    }
    @GetMapping("/detalhar/{chave}")
    @Override
    public ModelAndView detalhar(@PathVariable String chave) {
        ModelAndView mv = new ModelAndView("materias/detalhar.html");
        mv.addObject("materia", ms.busca(chave));
        return mv;
    }
}
