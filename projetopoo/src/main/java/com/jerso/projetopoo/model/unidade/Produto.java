package com.jerso.projetopoo.model.unidade;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    @Column
    private String _nome;
    @Column
    private String _marca;
    @Column(nullable = true)
    private LocalDate _diaConsumido = null;
    @Column
    private float _preco;

    public Produto(String nome, String marca, LocalDate diaConsumido, float preco) {
        this._nome = nome;
        this._marca = marca;
        this._diaConsumido = diaConsumido;
        this._preco = preco;
    }

    // Setters

    public void SetNome(String nome) {
        this._nome = nome;
    }

    public void SetMarca(String marca) {
        this._marca = marca;
    }

    public void SetDiaConsumido(LocalDate diaConsumido) {
        this._diaConsumido = diaConsumido;
    }

    public void SetPreco(float preco) {
        this._preco = preco;
    }

    // Getters

    public String GetNome() {
        return this._nome;
    }

    public String getMarca() {
        return this._marca;
    }

    public LocalDate getDiaConsumido() {
        return _diaConsumido;
    }

    public float getPreco() {
        return this._preco;
    }

}