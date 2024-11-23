package com.jb.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jb.helpdesk.domain.enums.Prioridade;
import com.jb.helpdesk.domain.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Chamado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String observacoes;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado() {
        super();
    }

    public Chamado(Integer id, Prioridade prioridade, Status status, String observacoes, String titulo, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.observacoes = observacoes;
        this.titulo = titulo;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public Chamado setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public Chamado setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
        return this;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public Chamado setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
        return this;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public Chamado setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Chamado setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Chamado setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public Chamado setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Chamado setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado chamado)) return false;
        return Objects.equals(getId(), chamado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
