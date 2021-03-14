package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnidadesController {

    @Autowired
    private UnidadeRepository ur;

    @RequestMapping("/listar")
    public String paginaListar() {
        return "listaUnidades";
    }

    @RequestMapping("/cadastrar")
    public String paginaCadastro(Unidade u) {
        ur.save(u);
        return "cadastrarUnidade";
    }

}