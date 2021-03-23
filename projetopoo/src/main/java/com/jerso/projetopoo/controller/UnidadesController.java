package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UnidadesController {

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade")
    public ModelAndView paginaListar() {
        List<Unidade> unidades = ur.findAll();
        for (Unidade unidade : unidades) {
            System.out.println(unidade.getCep());
        }
        ModelAndView mv = new ModelAndView("listaUnidades");
        mv.addObject("unidades", unidades);
        return mv;
    }

    @GetMapping("/cadastrar-unidade")
    public String paginaCadastro() {
        return "cadastrarUnidade";
    }

    @PostMapping("/cadastrar-unidade")
    public String paginaCadastro(Unidade u, String cep) {
        u.setCep(cep);
        ur.save(u);
        return "cadastrarUnidade";
    }

    @GetMapping("/editar-unidade/{id}")
    public String edit(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("editarUnidade");
        Unidade u = ur.findById(id).get();
        mv.addObject("unidade", u);
        return "editarUnidade";
    }

    @PostMapping("/editar-unidade/{id}")
    public String edit(@PathVariable("id") long id, Unidade u) {
        ur.save(u);
        return "listaUnidades";
    }
}