package com.jerso.projetopoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnidadeController {

    @RequestMapping("/cadastrar")
    public String paginaCadastro() {
        return "cadastro";
    }
}