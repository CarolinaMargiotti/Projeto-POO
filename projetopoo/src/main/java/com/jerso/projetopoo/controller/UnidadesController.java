package com.jerso.projetopoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnidadesController {

    @RequestMapping("/listar")
    public String paginaListar() {
        return "listaUnidades";
    }

    @RequestMapping("/cadastrar")
    public String paginaCadastro() {
        return "cadastrarUnidade";
    }

}