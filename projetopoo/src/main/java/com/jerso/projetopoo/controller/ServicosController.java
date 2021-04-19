package com.jerso.projetopoo.controller;

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

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicosController {

    @Autowired
    private UnidadeRepository ur;

    @GetMapping("/listar-unidade/{id}/listar-servicos")
    public ModelAndView paginaListar(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        List<Servico> servicos = u.getListaServicos();
        ModelAndView mv = new ModelAndView("crudServico/listaServicos");
        mv.addObject("servicos", servicos);
        mv.addObject("unidade", u);
        return mv;
    }

    @GetMapping("/cadastrar-unidade/{id}/cadastrar-servicos")
    public ModelAndView paginaCadastro(@PathVariable("id") long id) {
        Unidade u = ur.findById(id).get();
        ModelAndView mv = new ModelAndView("crudServico/cadastrarServicos");
        mv.addObject("listageneros", getGenerosList());
        mv.addObject("unidade", u);
        return mv;
    }

    // @ModelAttribute("listaGeneros")
    public List<String> getGenerosList() {
        List<String> generos = new ArrayList<String>();
        generos.add("Homem");
        generos.add("Mulher");
        generos.add("Ambos");
        return generos;
    }

    @PostMapping("/cadastrar-unidade/{id}/cadastrar-servicos")
    public ModelAndView paginaCadastro(@PathVariable("id") long id, Servico s, String nome, String genero,
            float preco) {
        System.out.println("\n\n\nnome: " + nome + "\ngenero:" + genero + "\npreco: " + preco + "\n\n\n");
        Unidade u = ur.findById(id).get();
        u.setUltimoIdServico(u.getUltimoIdServico() + 1);
        s.setId(u.getUltimoIdServico() + 0);
        s.setNome(nome);
        s.setGenero(genero);
        s.setPreco(preco);
        u.setListaServicos(s);
        ur.save(u);
        return paginaCadastro(id);// "/cadastrar-unidade/" + id + "/cadastrar-servicos";
    }

    @GetMapping("/editar-unidade/{id}/editar-servico/{idservico}")
    public ModelAndView paginaEditar(@PathVariable("id") long id, @PathVariable("idservico") long idservico) {
        ModelAndView mv = new ModelAndView("crudServico/editarServicos");
        Unidade u = ur.findById(id).get();
        Servico p = u.getServicoById(idservico);
        mv.addObject("servico", p);
        mv.addObject("unidade", u);
        return mv;
    }

    @PostMapping("/editar-unidade/{id}/editar-servico")
    public ModelAndView paginaEditar(@PathVariable("id") long id, Servico p) {
        Unidade u = ur.findById(id).get();
        u.saveServico(p);
        ur.save(u);
        return paginaListar(id);
    }

    @RequestMapping("/deletar-unidade/{id}/deletar-servico/{idservico}")
    public ModelAndView deletarUnidade(@PathVariable("id") long id, @PathVariable("idservico") long idservico) {
        Unidade u = ur.findById(id).get();
        System.out.println("\n\n\n" + idservico + "\n\n\n");
        u.deleteServico(idservico);
        return paginaListar(id);
    }
}
