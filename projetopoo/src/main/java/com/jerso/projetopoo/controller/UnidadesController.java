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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnidadesController {

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade")
    public ModelAndView paginaListar() {
        List<Unidade> unidades = ur.findAll();
        ModelAndView mv = new ModelAndView("crudUnidade/listaUnidades");
        mv.addObject("unidades", unidades);
        return mv;
    }

    @GetMapping("/cadastrar-unidade")
    public String paginaCadastro() {
        return "crudUnidade/cadastrarUnidade";
    }

    @PostMapping("/cadastrar-unidade")
    public String paginaCadastro(Unidade u, String cep) {
        u.setCep(cep);
        u.setUltimoIdProduto(0);
        ur.save(u);
        return "crudUnidade/cadastrarUnidade";
    }

    @GetMapping("/editar-unidade/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("crudUnidade/editarUnidade");
        Unidade u = ur.findById(id).get();
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/editar-unidade")
    public ModelAndView edit(long id, Unidade u) {
        Unidade u2 = ur.findById(id).get();
        u2.setCep(u.getCep());
        ur.save(u2);
        return paginaListar();
    }

    @RequestMapping("/deletar-unidade/{id}")
    public ModelAndView deletarUnidade(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        ur.delete(u);
        return paginaListar();
    }

}