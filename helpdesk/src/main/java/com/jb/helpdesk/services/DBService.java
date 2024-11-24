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

//    public void instanciaDB(){
//        Tecnico tec1 = new Tecnico("123", "tecnico@tecnico.com", "29223172004", "John", null);
//        Tecnico tec2 = new Tecnico("456", "tecnico2@tecnico.com", "48842358002", "Carlito", null);
//        Tecnico tec3 = new Tecnico("789", "tecnico3@tecnico.com", "72339913080", "Carlito", null);
//        tec1.addPerfil(Perfil.ADMIN);
//        tec2.addPerfil(Perfil.TECNICO);
//        tec3.addPerfil(Perfil.TECNICO);
//
//        Cliente cli1 = new Cliente("123","linus@email.com","18716473043","Linus Torvalds",null);
//
//        Cliente cli2 = new Cliente("456","marcio@email.com","35261863082","Marcio Francisco",null);
//
//        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01", "Primeiro chamado",tec1, cli1 );
//
//        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO,"Chamado 02", "Segundo chamado",tec2, cli1 );
//
//        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
//        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
//        chamadoRepository.saveAll(Arrays.asList(c1, c2));
//    }

    public void instanciaDB() {
        // Criando Técnicos
        Tecnico tec1 = new Tecnico("123", "tecnico@tecnico.com", "29223172004", "John", null);
        Tecnico tec2 = new Tecnico("456", "tecnico2@tecnico.com", "48842358002", "Carlito", null);
        Tecnico tec3 = new Tecnico("789", "tecnico3@tecnico.com", "28174173056", "Maria", null);
        Tecnico tec4 = new Tecnico("101", "tecnico4@tecnico.com", "90774335033", "Julia", null);
        Tecnico tec5 = new Tecnico("102", "tecnico5@tecnico.com", "01976919002", "Carlos Silva", null);

        // Adicionando Perfis
        tec1.addPerfil(Perfil.ADMIN);
        tec2.addPerfil(Perfil.TECNICO);
        tec3.addPerfil(Perfil.TECNICO);
        tec4.addPerfil(Perfil.TECNICO);
        tec5.addPerfil(Perfil.ADMIN);

        // Criando Clientes
        Cliente cli1 = new Cliente("123", "linus@email.com", "51746260076", "Linus Torvalds", null);
        Cliente cli2 = new Cliente("456", "marcio@email.com", "84963008033", "Marcio Francisco", null);
        Cliente cli3 = new Cliente("789", "ana@email.com", "14507777089", "Ana Silva", null);
        Cliente cli4 = new Cliente("101", "jose@email.com", "54768536000", "José Almeida", null);
        Cliente cli5 = new Cliente("102", "claudia@email.com", "88828925060", "Claudia Mendes", null);

        // Criando Chamados
        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 02", "Segundo chamado", tec2, cli1);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 03", "Terceiro chamado", tec3, cli2);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 04", "Quarto chamado", tec4, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 05", "Quinto chamado", tec5, cli4);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 06", "Sexto chamado", tec2, cli5);
        Chamado c7 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 07", "Sétimo chamado", tec3, cli3);
        Chamado c8 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 08", "Oitavo chamado", tec4, cli4);
        Chamado c9 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 09", "Nono chamado", tec1, cli5);
        Chamado c10 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 10", "Décimo chamado", tec5, cli2);

        // Salvando no Repositório
        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }

}
