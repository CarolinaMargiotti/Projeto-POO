package com.jerso.projetopoo.model.unidade;

import java.util.List;

import javax.persistence.Entity;




public class Unidades {
    private List<Unidade> _listaUnidades;

    public void AddUnidades(Unidade u){
        _listaUnidades.add(u);
    }
}



