package com.jerso.projetopoo.model.unidade;

import java.time.LocalDateTime;
import com.jerso.projetopoo.model.cliente.Cliente;

public class Apontamento {
    private Long id;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private Servico servico;

    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    // Getters

    public long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }
}
