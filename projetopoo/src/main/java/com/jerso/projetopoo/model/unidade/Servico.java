package com.jerso.projetopoo.model.unidade;

public class Servico {

    private Long _id;
    private String _nome;
    private String _genero;

    Servico(String nome, String genero) {
        this._nome = nome;
        this._genero = genero;
    }

    // Setters

    public void SetNome(String nome) {
        this._nome = nome;
    }

    public void SetGenero(String genero) {
        this._genero = genero;
    }

    // Getters

    public String GetNome() {
        return _nome;
    }

    public String GetGenero() {
        return _genero;
    }
}