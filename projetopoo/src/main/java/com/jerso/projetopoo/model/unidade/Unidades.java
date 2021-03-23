package com.jerso.projetopoo.model.unidade;

import java.util.List;

public class Unidades {
    private List<Unidade> listaUnidades;

    // funções da classe ;)

    public void addUnidades(Unidade u) {
        listaUnidades.add(u);
    }

    public void removeUnidades(Unidade u) {
        listaUnidades.remove(u);
    }

}
