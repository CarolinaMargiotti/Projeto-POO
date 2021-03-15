package com.jerso.projetopoo.model.unidade;

import javax.persistence.Entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Servico {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    @Column
    private String _nome;
    @Column
    private String _genero;

    public Servico(String nome, String genero) {
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