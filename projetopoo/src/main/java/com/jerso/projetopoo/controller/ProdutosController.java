package com.jerso.projetopoo.controller;

import com.jerso.projetopoo.db.UnidadeRepository;
import com.jerso.projetopoo.model.unidade.Produto;
import com.jerso.projetopoo.model.unidade.Unidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProdutosController {

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade/{id}/listar-produtos")
    public ModelAndView paginaListar(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        System.out.println(u);
        List<Produto> produtos = u.getListaProdutos();
        ModelAndView mv = new ModelAndView("crudProduto/listaProdutos");
        mv.addObject("produtos", produtos);
        mv.addObject("unidade", u);
        return mv;
    }

    @GetMapping("/cadastrar-unidade/{id}/cadastrar-produtos")
    public ModelAndView paginaCadastro(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        ModelAndView mv = new ModelAndView("crudProduto/cadastrarProdutos");
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/cadastrar-unidade/{id}/cadastrar-produtos")
    public ModelAndView paginaCadastro(@PathVariable("id") long id, Produto p, String nome, String marca, float preco) {
        Unidade u = ur.findById(id).get();
        u.setUltimoIdProduto(u.getUltimoIdProduto() + 1);
        p.setId(u.getUltimoIdProduto() + 0);
        p.setNome(nome);
        p.setMarca(marca);
        p.setPreco(preco);
        u.setListaProdutos(p);
        ur.save(u);
        return paginaCadastro(id);// "/cadastrar-unidade/" + id + "/cadastrar-produtos";
    }

    @GetMapping("/editar-unidade/{id}/editar-produto/{idProduto}")
    public ModelAndView paginaEditar(@PathVariable("id") long id, @PathVariable("idProduto") long idProduto) {
        ModelAndView mv = new ModelAndView("crudProduto/editarProdutos");
        Unidade u = ur.findById(id).get();
        System.out.println(u);
        Produto p = u.getProdutoById(idProduto);
        mv.addObject("produto", p);
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/editar-unidade/{id}/editar-produto")
    public ModelAndView paginaEditar(@PathVariable("id") long id, Produto p) {
        Unidade u = ur.findById(id).get();
        u.saveProduto(p);
        ur.save(u);
        return paginaListar(id);
    }

    @RequestMapping("/deletar-unidade/{id}/deletar-produto/{idProduto}")
    public ModelAndView deletarUnidade(@PathVariable("id") long id, @PathVariable("idProduto") long idProduto) {
        Unidade u = ur.findById(id).get();
        System.out.println("\n\n\n" + idProduto + "\n\n\n");
        u.deleteProduto(idProduto);
        return paginaListar(id);
    }
}
