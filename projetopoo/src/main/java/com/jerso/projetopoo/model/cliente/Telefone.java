package com.jerso.projetopoo.model.cliente;

public class Telefone{
    private int _ddd;
    private String _numero;

    Telefone(int ddd, String numero){
        SetNum(ddd, numero);
    }

    public void SetNum(int ddd, String numero){
        this._ddd=ddd;
        this._numero=numero;
    }

    //Getters

    public int getDDD(){
        return  this._ddd;
    }

    public String getNumero(){
        return this._numero;
    }

    public String getTelefone(){
        return "("+this._ddd+") "+this._numero;
    }

}