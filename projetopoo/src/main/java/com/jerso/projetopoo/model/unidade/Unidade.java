package com.jerso.projetopoo.model.unidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import com.jerso.projetopoo.model.cliente.Cliente;
import com.jerso.projetopoo.model.cliente.Clientes;

@Entity
public class Unidade {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private Long ultimoIdProduto;

    @Column()
    private String cep;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "idUnidade", nullable = true)
    @OrderColumn(name = "Ordem")
    private List<Servico> listaServicos = new ArrayList<Servico>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "idUnidade", nullable = true)
    @OrderColumn(name = "Ordem")
    private List<Produto> listaProdutos = new ArrayList<Produto>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "idUnidade", nullable = true)
    private Clientes cliente;

    public void removeCliente(Cliente c) {
        cliente.removeCliente(c);
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Setters
    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setListaServicos(Servico servico) {
        listaServicos.add(servico);
    }

    public void setListaProdutos(Produto produto) {
        listaProdutos.add(produto);
    }

    public void setCliente(Cliente c) {
        cliente.addCliente(c);
    }

    public void setUltimoIdProduto(long id) {
        this.ultimoIdProduto = id;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public Clientes getClientes() {
        return cliente;
    }

    public long getUltimoIdProduto() {
        return this.ultimoIdProduto;
    }

    // others

    public Produto getProdutoById(long id) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void saveProduto(Produto p) {
        if (!listaProdutos.contains(p)) {
            for (int i = 0; i <= listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getId() == p.getId()) {
                    listaProdutos.set(i, p);
                }
            }
        }
    }

    public void deleteProduto(long id) {
        for (int i = 0; i <= listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id) {
                listaProdutos.remove(i);
            }
        }
    }

    public void a() {

    }

}