package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.ProdutoRepository;
import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Produto;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/cadastrar-unidade/{id}/cadastrar-produtos")
    public ModelAndView paginaCadastro(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        ModelAndView mv = new ModelAndView("CadastrarProdutos");
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/cadastrar-unidade/{id}/cadastrar-produtos")
    public String paginaCadastro(@PathVariable("id") long id, Produto p, String nome, String marca, float preco) {
        Unidade u = ur.findById(id).get();
        p.setNome(nome);
        p.setMarca(marca);
        p.setPreco(preco);
        u.addProduto(p);
        System.out.println(p);
        ur.save(u);

        return "/cadastrar-unidade/" + id + "/cadastrar-produtos";
    }
}
