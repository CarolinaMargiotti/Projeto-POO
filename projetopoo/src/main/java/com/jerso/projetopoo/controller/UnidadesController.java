package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UnidadesController {

    @Autowired
    private UnidadeRepository ur;

    @RequestMapping("/listar-unidade")
    public ModelAndView paginaListar() {
        List<Unidade> unidades = ur.findAll();
        ModelAndView mv = new ModelAndView("listaUnidades");
        mv.addObject("unidades", unidades);
        return mv;
    }

    @RequestMapping("/cadastrar-unidade")
    public String paginaCadastro(Unidade u) {
        ur.save(u);
        return "cadastrarUnidade";
    }

}