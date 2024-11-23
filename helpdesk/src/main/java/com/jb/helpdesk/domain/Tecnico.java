package com.jb.helpdesk.domain;

import com.jb.helpdesk.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa{

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(String senha, String email, String cpf, String nome, Integer id) {
        super(senha, email, cpf, nome, id);
        addPerfil(Perfil.CLIENTE);
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
