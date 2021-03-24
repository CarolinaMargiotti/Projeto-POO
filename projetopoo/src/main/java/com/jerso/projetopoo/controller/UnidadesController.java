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
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("editarUnidade");
        Unidade u = ur.findById(id).get();
        System.out.println(u.getCep());
        System.out.println(u.getId());
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/editar-unidade")
    public String edit(long id, Unidade u) {
        Unidade u2 = ur.findById(id).get();
        u2.setCep(u.getCep());

        ur.save(u2);
        return "listaUnidades";
    }
}