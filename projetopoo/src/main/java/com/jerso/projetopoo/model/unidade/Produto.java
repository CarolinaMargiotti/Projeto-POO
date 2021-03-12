package com.jerso.projetopoo.model.unidade;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String _nome;
    private String _marca;
    private LocalDate _diaConsumido = null;
    private float _preco;

    Produto(String nome, String marca, LocalDate diaConsumido, float preco) {
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