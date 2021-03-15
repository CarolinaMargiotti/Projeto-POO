package com.jerso.projetopoo.model.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.jerso.projetopoo.model.unidade.Produto;
import com.jerso.projetopoo.model.unidade.Servico;

@Entity
public class Cliente {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    @Column
    private String _nome;
    @Column
    private String _genero;
    @Column
    private LocalDate _dataNascimento;
    @Column
    private String _tel;

    @ElementCollection
    @CollectionTable(name = "_listaProdutosCliente", joinColumns = @JoinColumn(name = "_idUnidade"))
    @Column(name = "_listaProdutosCliente")
    private List<Produto> _listaProdutos;

    @ElementCollection
    @CollectionTable(name = "_listaServicosCliente", joinColumns = @JoinColumn(name = "_idUnidade"))
    @Column(name = "_listaServicosCliente")
    private List<Servico> _listaServicos;

    public Cliente(String nome, String genero, LocalDate dataNascimento, String tel) {
        this._nome = nome;
        this._genero = genero;
        this._dataNascimento = dataNascimento;
        this._tel = tel;
    }

    // Setters

    public void AddProduto(Produto produto) {
        _listaProdutos.add(produto);
    }

    public void AddServico(Servico servico) {
        _listaServicos.add(servico);
    }

    public void SetNome(String nome) {
        this._nome = nome;
    }

    public void SetGenero(String genero) {
        this._genero = genero;
    }

    public void SetDataNascimento(LocalDate dataNascimento) {
        this._dataNascimento = dataNascimento;
    }

    public void SetTel(String tel) {
        this._tel = tel;
    }

    // Getters

    public List<Produto> GetListaProdutos() {
        return _listaProdutos;
    }

    public List<Servico> GetListaServicos() {
        return _listaServicos;
    }

    public String GetNome() {
        return _nome;
    }

    public String GetGenero() {
        return _genero;
    }

    public LocalDate GetDataNascimento() {
        return _dataNascimento;
    }

    public String GetTelefone() {
        return this._tel;
    }

    // Deletes

    public void RemoveProduto(Produto prod) {
        _listaProdutos.remove(prod);
    }

    public void RemoveServico(Servico servico) {
        _listaServicos.remove(servico);
    }

    // Outros

    public boolean ProdutoExists(Produto prod) {
        if (_listaProdutos.indexOf(prod) != -1)
            return true;
        else
            return false;
    }

    public int GetIdade() {
        return Period.between(_dataNascimento, LocalDate.now()).getYears();
    }

}