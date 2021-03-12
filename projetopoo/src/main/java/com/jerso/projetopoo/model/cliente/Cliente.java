package com.jerso.projetopoo.model.cliente;

import com.jerso.projetopoo.model.unidade.Produto;
import com.jerso.projetopoo.model.unidade.Servico;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.persistence.*;

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String _nome;
    private String _genero;
    private LocalDate _dataNascimento;
    private Telefone _tel;
    private List<Produto> _listaProdutos;
    private List<Servico> _listaServicos;

    Cliente(String nome, String genero, LocalDate dataNascimento, Telefone tel) {
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

    public void SetTel(Telefone tel) {
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

    public Telefone GetTelefone() {
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