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
    private Long id;
    @Column
    private String nome;
    @Column
    private String genero;
    @Column
    private LocalDate dataNascimento;
    @Column
    private String tel;

    @ElementCollection
    @CollectionTable(name = "listaProdutosCliente", joinColumns = @JoinColumn(name = "idCliente"))
    @Column(name = "listaProdutos")
    private List<Produto> listaProdutos;

    @ElementCollection
    @CollectionTable(name = "listaServicosCliente", joinColumns = @JoinColumn(name = "idCliente"))
    @Column(name = "listaServicos")
    private List<Servico> listaServicos;

    public Cliente(String nome, String genero, LocalDate dataNascimento, String tel) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
    }

    // Setters

    public void addProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public void addServico(Servico servico) {
        listaServicos.add(servico);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // Getters

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return this.tel;
    }

    // Deletes

    public void removeProduto(Produto prod) {
        listaProdutos.remove(prod);
    }

    public void removeServico(Servico servico) {
        listaServicos.remove(servico);
    }

    // Outros

    public boolean produtoExists(Produto prod) {
        if (listaProdutos.indexOf(prod) != -1)
            return true;
        else
            return false;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}