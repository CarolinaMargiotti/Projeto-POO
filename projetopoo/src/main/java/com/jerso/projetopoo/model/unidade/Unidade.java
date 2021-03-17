package com.jerso.projetopoo.model.unidade;

import com.jerso.projetopoo.model.cliente.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Unidade {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String cep;

    @ElementCollection
    @CollectionTable(name = "listaServicos", joinColumns = @JoinColumn(name = "idUnidade"))
    @Column(name = "listaServicos", nullable = true)
    private List<Servico> listaServicos;

    @ElementCollection
    @CollectionTable(name = "listaProdutos", joinColumns = @JoinColumn(name = "idUnidade"))
    @Column(name = "listaProdutos", nullable = true)
    private List<Produto> listaProdutos;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUnidade", nullable = true)
    private Clientes cliente;
    /*
     * public Unidade(String cep) { this.cep = cep; }
     */

    /*
     * public Unidade(Long id, String cep) { this.id = id; this.cep = cep; }
     */

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

    public void addServicos(Servico servico) {
        listaServicos.add(servico);
    }

    public void addProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public void addCliente(Cliente c) {
        cliente.addCliente(c);
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public List<Servico> getServicos() {
        return listaServicos;
    }

    public List<Produto> getProdutos() {
        return listaProdutos;
    }

    public Clientes getClientes() {
        return cliente;
    }

}