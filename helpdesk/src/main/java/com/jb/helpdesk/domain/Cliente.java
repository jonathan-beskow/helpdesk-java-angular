package com.jb.helpdesk.domain;

import com.jb.helpdesk.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(String senha, String email, String cpf, String nome, Integer id) {
        super(senha, email, cpf, nome, id);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public Cliente setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
        return this;
    }
}
