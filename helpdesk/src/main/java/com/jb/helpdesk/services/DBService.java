package com.jb.helpdesk.services;

import com.jb.helpdesk.domain.Chamado;
import com.jb.helpdesk.domain.Cliente;
import com.jb.helpdesk.domain.Tecnico;
import com.jb.helpdesk.domain.enums.Perfil;
import com.jb.helpdesk.domain.enums.Prioridade;
import com.jb.helpdesk.domain.enums.Status;
import com.jb.helpdesk.repositories.ChamadoRepository;
import com.jb.helpdesk.repositories.ClienteRepository;
import com.jb.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico("123", "tecnico@tecnico.com", "725.264.000-07", "John", null);
        Tecnico tec2 = new Tecnico("456", "tecnico2@tecnico.com", "435.691.090-89", "Carlito", null);
        Tecnico tec3 = new Tecnico("789", "tecnico3@tecnico.com", "830.576.011-34", "Carlito", null);
        tec1.addPerfil(Perfil.ADMIN);
        tec2.addPerfil(Perfil.TECNICO);
        tec3.addPerfil(Perfil.TECNICO);

        Cliente cli1 = new Cliente("123","linus@email.com","187.164.730-43","Linus Torvalds",null);

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01", "Primeiro chamado",tec1, cli1 );

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
