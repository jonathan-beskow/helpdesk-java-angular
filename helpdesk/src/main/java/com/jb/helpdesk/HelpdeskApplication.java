package com.jb.helpdesk;

import com.jb.helpdesk.domain.Chamado;
import com.jb.helpdesk.domain.Cliente;
import com.jb.helpdesk.domain.Tecnico;
import com.jb.helpdesk.domain.enums.Perfil;
import com.jb.helpdesk.domain.enums.Prioridade;
import com.jb.helpdesk.domain.enums.Status;
import com.jb.helpdesk.repositories.ChamadoRepository;
import com.jb.helpdesk.repositories.ClienteRepository;
import com.jb.helpdesk.repositories.PessoaRepository;
import com.jb.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;


	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico("123", "tecnico@tecnico.com", "725.264.000-07", "John", null);
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente("123","linus@email.com","187.164.730-43","Linus Torvalds",null);

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01", "Primeiro chamado",tec1, cli1 );

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
