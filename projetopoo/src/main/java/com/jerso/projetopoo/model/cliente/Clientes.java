package com.jerso.projetopoo.model.cliente;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Clientes {
    private List<Cliente> _listaClientes;

    public void AddCliente(Cliente cliente) {
        _listaClientes.add(cliente);
    }

    public void RemoveCliente(Cliente cliente) {
        _listaClientes.remove(cliente);
    }

    public int GetIdadeMedia() {
        int idade = 0;
        for (Cliente cliente : _listaClientes) {
            idade += cliente.GetIdade();
        }
        return idade / _listaClientes.size();
    }

    public int GetIdadeMediaGenero(String genero) {
        List<Cliente> clientegenero = _listaClientes.stream().filter(c -> c.GetGenero() == genero)
                .collect(Collectors.toList());
        int idade = 0;
        for (Cliente cliente : clientegenero) {
            idade += cliente.GetIdade();
        }
        return idade / clientegenero.size();
    }

    public int GetServicoMaisProcurado() {
        return 0;
    }

    public int GetServicoMaisProcuradoGenero(String genero) {
        return 0;
    }

}