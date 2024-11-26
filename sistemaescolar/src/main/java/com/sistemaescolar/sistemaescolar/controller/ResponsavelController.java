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
import com.sistemaescolar.sistemaescolar.service.AlunoService;
import com.sistemaescolar.sistemaescolar.service.ResponsavelService;


@Controller
@RequestMapping("/responsaveis")
public class ResponsavelController implements IControladores<Responsavel,String> {

    private ResponsavelService rs;

    private AlunoService as;

    public ResponsavelController(ResponsavelService rs, AlunoService as){
        this.rs = rs;
        this.as = as;
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
        mv.addObject("responsavel", rs.todos());
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

	@GetMapping("detalhar/{chave}")
	@Override
	public ModelAndView detalhar(@PathVariable String chave) {
		ModelAndView mv = new ModelAndView("responsaveis/detalhar.html");
        mv.addObject("responsavel", rs.busca(chave));
        mv.addObject("aluno", as.buscaPorResp(chave));
        return mv;
    }

    @GetMapping("editar/voltarEditar")
    public ModelAndView voltarEditar(){
        ModelAndView mv = new ModelAndView("redirect:../../responsaveis");
        return mv;
    }
    @GetMapping("detalhar/voltarDetalhar")
    public ModelAndView voltarDetalhar(){
        ModelAndView mv = new ModelAndView("redirect:../../responsaveis");
        return mv;
    }
}
