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
    private Long _idUnidade;

    @Column()
    private String _cep;

    @ElementCollection
    @CollectionTable(name = "_listaServicos", joinColumns = @JoinColumn(name = "_idUnidade"))
    @Column(name = "_listaServicos")
    private List<Servico> _listaServicos;

    @ElementCollection
    @CollectionTable(name = "_listaProdutos", joinColumns = @JoinColumn(name = "_idUnidade"))
    @Column(name = "_listaProdutos")
    private List<Produto> _listaProdutos;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "_idUnidade")
    private Clientes _cliente;

    Unidade(Long idUnidade, String cep) {
        this._idUnidade = idUnidade;
        this._cep = cep;
    }

    public void RemoveCliente(Cliente c) {
        _cliente.RemoveCliente(c);
    }

    // Setters
    public void SetCep(String cep) {
        this._cep = cep;
    }

    public void AddServicos(Servico servico) {
        _listaServicos.add(servico);
    }

    public void AddProduto(Produto produto) {
        _listaProdutos.add(produto);
    }

    public void AddCliente(Cliente c) {
        _cliente.AddCliente(c);
    }

    // Getters
    public Long GetIDUnidade() {
        return _idUnidade;
    }

    public String GetCep() {
        return this._cep;
    }

    public List<Servico> GetServicos() {
        return _listaServicos;
    }

    public List<Produto> GetProdutos() {
        return _listaProdutos;
    }

}