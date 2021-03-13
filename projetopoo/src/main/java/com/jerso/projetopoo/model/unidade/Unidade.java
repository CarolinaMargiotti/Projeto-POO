package com.jerso.projetopoo.model.unidade;

import java.security.Identity;

import com.jerso.projetopoo.model.cliente.*;
import java.util.List;

public class Unidade {
    private Long _idUnidade;
    private String _cep;
    private List<Servico> _listaServicos;
    private List<Produto> _listaProdutos;
    private Clientes _cliente;

    Unidade(Long idUnidade, String cep) {
        this._idUnidade = idUnidade;
        this._cep = cep;
    }

    public Long GetIDUnidade() {
        return _idUnidade;
    }

    public void AddCliente(Cliente c) {
        _cliente.AddCliente(c);
    }

    public void RemoveCliente(Cliente c) {
        _cliente.RemoveCliente(c);
    }

}