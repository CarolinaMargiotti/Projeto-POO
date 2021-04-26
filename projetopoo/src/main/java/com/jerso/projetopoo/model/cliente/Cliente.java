package com.jerso.projetopoo.model.cliente;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

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
    private String dataNascimento;
    @Column
    private String tel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "idCliente", nullable = true)
    @OrderColumn(name = "Ordem")
    private List<Produto> listaProdutosCliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "idCliente", nullable = true)
    @OrderColumn(name = "Ordem")
    private List<Servico> listaServicosCliente;

    public Cliente(String nome, String genero, String dataNascimento, String tel) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
    }

    // Setters

    public void setListaProdutosCliente(Produto produto) {
        listaProdutosCliente.add(produto);
    }

    public void setListaServicosCliente(Servico servico) {
        listaServicosCliente.add(servico);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // Getters

    public List<Produto> getlistaProdutosCliente() {
        return listaProdutosCliente;
    }

    public List<Servico> getListaServicosCliente() {
        return listaServicosCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTel() {
        return this.tel;
    }

    // Deletes

    public void removeProduto(Produto prod) {
        listaProdutosCliente.remove(prod);
    }

    public void removeServico(Servico servico) {
        listaServicosCliente.remove(servico);
    }

    // Outros

    public boolean produtoExists(Produto prod) {
        if (listaProdutosCliente.indexOf(prod) != -1)
            return true;
        else
            return false;
    }

    public int getIdade() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Period.between(LocalDate.parse(dataNascimento, dateTimeFormatter), LocalDate.now()).getYears();
    }

}