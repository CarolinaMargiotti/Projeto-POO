package com.jerso.projetopoo.model.unidade;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    private String marca;
    @Column(nullable = true)
    private LocalDate diaConsumido = null;
    @Column
    private float preco;

    /*
     * public Produto(String nome, String marca, LocalDate diaConsumido, float
     * preco) { this.nome = nome; this.marca = marca; this.diaConsumido =
     * diaConsumido; this.preco = preco; }
     */

    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDiaConsumido(LocalDate diaConsumido) {
        this.diaConsumido = diaConsumido;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getters

    public String getNome() {
        return this.nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public LocalDate getDiaConsumido() {
        return diaConsumido;
    }

    public float getPreco() {
        return this.preco;
    }

    public long getId() {
        return this.id;
    }
}