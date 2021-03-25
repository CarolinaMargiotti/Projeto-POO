package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.ProdutoRepository;
import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Produto;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoRepository pr;

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade/{id}/listar-produtos")
    public ModelAndView paginaListar(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        List<Produto> produtos = u.getProdutos();
        ModelAndView mv = new ModelAndView("listaProdutos");
        mv.addObject("produtos", produtos);
        mv.addObject("unidade", u);
        return mv;
    }

}
