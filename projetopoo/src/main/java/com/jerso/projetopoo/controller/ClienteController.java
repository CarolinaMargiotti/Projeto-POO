package com.jerso.projetopoo.controller;

import java.util.List;

import com.jerso.projetopoo.db.UnidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Servico;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jerso.projetopoo.model.cliente.*;

public class ClienteController {

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade/{id}/listar-clientes")
    public ModelAndView paginaListar(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        Clientes clientes = u.getClientes();
        ModelAndView mv = new ModelAndView("crudCliente/listaClientes");
        mv.addObject("clientes", clientes.getListaClientes());
        mv.addObject("unidade", u);
        return mv;
    }

    @GetMapping("/cadastrar-clientes")
    public ModelAndView paginaCadastrar() {
        List<Unidade> listaUnidade = ur.findAll();
        ModelAndView mv = new ModelAndView("crudCliente/cadastrarClientes");
        mv.addObject("unidades", listaUnidade);
        return mv;
    }

}
