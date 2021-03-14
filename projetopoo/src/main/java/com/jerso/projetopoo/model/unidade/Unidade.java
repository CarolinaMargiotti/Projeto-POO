package com.jerso.projetopoo.model.unidade;

import com.jerso.projetopoo.model.cliente.*;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unidade {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _idUnidade;
    @Column()
    private String _cep;
    @Column()
    private List<Servico> _listaServicos;
    @Column()
    private List<Produto> _listaProdutos;

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