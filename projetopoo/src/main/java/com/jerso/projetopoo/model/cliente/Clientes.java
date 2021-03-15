package com.jerso.projetopoo.model.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _idClientes;

    @ElementCollection
    @CollectionTable(name = "_listaClientes", joinColumns = @JoinColumn(name = "_idUnidade"))
    @Column(name = "_listaClientes")
    private List<Cliente> _listaClientes;

    public Clientes() {

    }

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