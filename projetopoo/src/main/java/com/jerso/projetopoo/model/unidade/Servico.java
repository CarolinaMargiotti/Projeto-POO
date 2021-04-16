package com.jerso.projetopoo.model.unidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String genero;
    @Column
    private float preco;

    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    public float getPreco() {
        return this.preco;
    }
}