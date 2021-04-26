package com.jerso.projetopoo.model.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "id", nullable = true)
    @OrderColumn(name = "Ordem")
    private List<Cliente> listaClientes;

    public void setListaClientes(Cliente cliente) {
        System.out.println("\n\n\n" + cliente.getNome() + "\n\n\n");
        listaClientes.add(cliente);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void removeCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public int getIdadeMedia() {
        int idade = 0;
        for (Cliente cliente : listaClientes) {
            idade += cliente.getIdade();
        }
        return idade / listaClientes.size();
    }

    public int getIdadeMediaGenero(String genero) {
        List<Cliente> clientegenero = listaClientes.stream().filter(c -> c.getGenero() == genero)
                .collect(Collectors.toList());
        int idade = 0;
        for (Cliente cliente : clientegenero) {
            idade += cliente.getIdade();
        }
        return idade / clientegenero.size();
    }

    public int getServicoMaisProcurado() {
        return 0;
    }

    public int getServicoMaisProcuradoGenero(String genero) {
        return 0;
    }

}