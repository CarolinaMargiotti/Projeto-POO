package com.jerso.projetopoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenericController {

    @RequestMapping("/index")
    public String paginaIndex() {
        return "index";
    }
}
