package com.jb.helpdesk.services;

import com.jb.helpdesk.domain.Cliente;
import com.jb.helpdesk.domain.Pessoa;
import com.jb.helpdesk.dto.ClienteDTO;
import com.jb.helpdesk.repositories.ClienteRepository;
import com.jb.helpdesk.repositories.PessoaRepository;
import com.jb.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.jb.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Cliente findById(Integer id) {
        Optional<Cliente> objeto = clienteRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaCliente(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return clienteRepository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        if (!objDTO.getSenha().equals(oldObj.getSenha())) {
            objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        }
        oldObj = new Cliente(objDTO);
        return clienteRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);

        if (!cliente.getChamados().isEmpty()) {
            throw new DataIntegrityViolationException("O cliente possui ordens de chamado e não pode ser deletado!");
        }
        clienteRepository.deleteById(id);

    }

    private void validaCliente(ClienteDTO clienteDTO) {
        //Valida se o cpf ja consta no bd
        Optional<Pessoa> obj = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != clienteDTO.getId()) {
            throw new DataIntegrityViolationException("CPF Já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(clienteDTO.getEmail());

        if (obj.isPresent() && obj.get().getId() != clienteDTO.getId()) {
            throw new DataIntegrityViolationException("Email Já cadastrado no sistema");
        }

    }
}
