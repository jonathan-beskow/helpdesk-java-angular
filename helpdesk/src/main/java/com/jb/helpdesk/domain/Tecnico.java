package com.jb.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jb.helpdesk.domain.enums.Perfil;
import com.jb.helpdesk.dto.TecnicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa {

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(String senha, String email, String cpf, String nome, Integer id) {
        super(senha, email, cpf, nome, id);
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public Tecnico setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
        return this;
    }
}
